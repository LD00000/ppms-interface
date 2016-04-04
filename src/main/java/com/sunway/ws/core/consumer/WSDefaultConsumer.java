package com.sunway.ws.core.consumer;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunway.ws.core.utils.PropertiesLoader;
import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.common.DataStatus;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;
import com.sunway.ws.module.common.dao.InterfaceDataStatusDaoImpl;

/**
 * WebService 消费者
 */
public class WSDefaultConsumer {
	
	private static final Logger logger = LogManager.getLogger(WSDefaultConsumer.class);
	
	private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();	// 不转换 null 字段	
	private final InterfaceDataStatusDaoImpl interfaceDataStatusDao = new InterfaceDataStatusDaoImpl();
	
	private MessageListener messageListener;
	private DataHandler dataHandler;
	private MessageExtInner message;
	private boolean persistLog;	// 是否记录日志
	private boolean logData;	// 是否记录数据对象
	private InterfaceDataStatusBean retryDataStatusBean;	// 要重发的数据
	
	public WSDefaultConsumer(WSInterface wsInterface) {
		this.message = new MessageExtInner(wsInterface, null, null);
		this.persistLog = true;
		this.logData = true;
		this.dataHandler = new DataHandler() {
			
			@Override
			public MessageExtInner handleMessage(MessageExtInner message) {
				return message;
			}
		};
		this.messageListener = new MessageListener() {
			
			@Override
			public DataStatus consumeMessage(MessageExtInner message) {
				if (message == null)
					return DataStatus.WARN_MESSAGE_IS_NULL;
				
				return DataStatus.WARN_UNREGISTER_LISTENER;
			}
		};
	}
	
	/**
	 * 设置要发送数据的主键，首次数据时使用
	 * 
	 * @param pk
	 * @param pkExts
	 * @return
	 */
	public WSDefaultConsumer setPk(String pk, String... pkExts) {
		this.message.setPk(pk);
		if (pkExts.length > 0) {
			this.message.setPkExt1(pkExts[0]);
			if (pkExts.length >= 2)
				this.message.setPkExt2(pkExts[1]);
		} 
		return this;
	}
	
	/**
	 * 注册数据处理监听
	 * 
	 * @param messageListener
	 */
	public void registerListener(MessageListener messageListener) {
		this.messageListener = messageListener;
	}
	
	/**
	 * 准备要推送的数据
	 * 
	 * @param data	数据对象
	 * @param pk	主键
	 * @param guid	GUID 
	 * @param pkExts	联合主键
	 * @return
	 */
	public WSDefaultConsumer prepareData(Object data, String guid, String pk, String... pkExts) {
		this.message.setData(data);
		this.message.setGuid(guid);
		this.message.setPk(pk);
		if (pkExts.length > 0) {
			this.message.setPkExt1(pkExts[0]);
			if (pkExts.length >= 2)
				this.message.setPkExt2(pkExts[1]);
		} 
		return this;
	}
	
	/**
	 * 补充要发送的数据</br>
	 * 用来记录日志
	 * 
	 * @param dataHandler
	 */
	public void handleMessage(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}
	
	/**
	 * 执行 MessageListener 中的消费方法
	 */
	public void run() {
		if (!message.hasData() && retryDataStatusBean == null)	
			return;	// 没有数据直接返回
		
		String exceptionStr = "";
		DataStatus dataStatus = DataStatus.FAILED;
		
		try {
			message = dataHandler.handleMessage(message);
			dataStatus = messageListener.consumeMessage(message);
			logger.info("{} 接口, {} {} {} 发送状态: {}", message.getWsInterface().getName(), message.getPk(), message.getPkExt1(), message.getPkExt2(), dataStatus);
		} catch (Exception e) {
			logger.error(message.getWsInterface().getName() + "接口  PK: " + message.getPk() + " 出错...", e);
			exceptionStr = ExceptionUtils.getStackTrace(e);
		}
		
		if (dataStatus == DataStatus.WARN_NO_CLIENT) {	
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", message.getWsInterface().getName());
			return;	// 无法获取客户端时不记录日志，直接返回
		}
		
		if (!persistLog) 	
			return;	// 不记录日志，直接返回
		
		if (retryDataStatusBean != null) {	// 重发数据时更新日志
			logger.info("更新日志...");
			final Integer retryTimes = retryDataStatusBean.getRetryTimes() + 1;
			retryDataStatusBean.setRetryTimes(retryTimes);
			if (retryTimes == PropertiesLoader.getInteger("retry.times") && dataStatus == DataStatus.FAILED) {
				retryDataStatusBean.setStatus(DataStatus.FAILED_TOO_MANY_TIMES.getStatus());
			} else {
				retryDataStatusBean.setStatus(dataStatus.getStatus());
			}
			retryDataStatusBean.setException(exceptionStr);
			retryDataStatusBean.setGuid(message.getGuid());
			retryDataStatusBean.setInstime(new Date());
			retryDataStatusBean.setData(gson.toJson(message.getData()));
			
			interfaceDataStatusDao.update(retryDataStatusBean);
			retryDataStatusBean = null;
		} else {	// 首次发送时插入日志
			logger.info("插入日志...");
			final InterfaceDataStatusBean interfaceDataStatus = new InterfaceDataStatusBean();
			interfaceDataStatus.setInterfaceName(message.getWsInterface().getName());
			interfaceDataStatus.setStatus(DataStatus.FAILED.getStatus());
			interfaceDataStatus.setRetryTimes(0);
			interfaceDataStatus.setGuid(message.getGuid());
			interfaceDataStatus.setbPk(message.getPk());
			interfaceDataStatus.setbPkExt1(message.getPkExt1());
			interfaceDataStatus.setbPkExt2(message.getPkExt2());
			interfaceDataStatus.setException(exceptionStr);
			interfaceDataStatus.setStatus(dataStatus.getStatus());
			interfaceDataStatus.setInstime(new Date());
			if (logData)
				interfaceDataStatus.setData(gson.toJson(message.getData()));
			
			interfaceDataStatusDao.insert(interfaceDataStatus);
		}
	}

	/**
	 * 重发数据</br> 
	 * 开启日志的情况下, 会增加重试次数
	 * 
	 * @param retryDataStatusBean 重发的数据
	 * @param clazz 数据类型
	 * @return
	 */
	public WSDefaultConsumer retry(InterfaceDataStatusBean retryDataStatusBean, Class<?> clazz) {
		this.prepareData(gson.fromJson(retryDataStatusBean.getData(), clazz), 
									   retryDataStatusBean.getGuid(),
									   retryDataStatusBean.getbPk(), 
									   retryDataStatusBean.getbPkExt1(), 
									   retryDataStatusBean.getbPkExt2());
		this.retryDataStatusBean = retryDataStatusBean;
		return this;
	}
	
	/**
	 * 设置是否记录日志, 默认开启
	 * 
	 * @param persistLog
	 */
	public void persistLog(boolean persistLog) {
		this.persistLog = persistLog;
	}
	
	/**
	 * 设置是否记录数据对象，默认开启
	 * 
	 * @param logData
	 */
	public void logData(boolean logData) {
		this.logData = logData;
	}

}
