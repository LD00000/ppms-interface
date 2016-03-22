package com.sunway.ws.core.consumer;

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
	private MessageExtInner message;
	private boolean persistLog;	// 是否记录日志
	private boolean logData;	// 是否记录数据对象
	private InterfaceDataStatusBean retryDataStatusBean;	// 要重发的数据
	
	public WSDefaultConsumer(WSInterface wsInterface) {
		this.message = new MessageExtInner();
		this.message.setWsInterface(wsInterface);
		this.persistLog = true;
		this.logData = true;
	}
	
	/**
	 * 准备要推送的数据
	 * 
	 * @param data	数据对象
	 * @param pk	主键
	 * @param pkExts	联合主键
	 * @return
	 */
	public WSDefaultConsumer prepareData(Object data, String pk, String... pkExts) {
		this.message.setData(data);
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
	 * 执行 MessageListener 中的消费方法
	 */
	public void run() {
		if (!message.hasData())	
			return;	// 没有数据直接返回
		
		String exceptionStr = "";
		DataStatus dataStatus = DataStatus.FAILED;
		
		try {
			dataStatus = messageListener.consumeMessage(message);
			logger.info("{}, {} 发送状态: {}", message.getWsInterface().getName(), message.getPk(), dataStatus);
		} catch (Exception e) {
			logger.error(message.getWsInterface().getName() + " consumer error...", e);
			exceptionStr = ExceptionUtils.getStackTrace(e);
		}
		
		if (dataStatus == DataStatus.WARN_NO_CLIENT)
			logger.warn("{} 接口未开启或在 i_config 表中无记录...", message.getWsInterface().getName());
		
		if (persistLog && dataStatus != DataStatus.WARN_NO_CLIENT) {	// 无法获取客户端时不记录日志
			if (this.retryDataStatusBean != null) {	// 重发数据时更新日志
				final Integer retryTimes = retryDataStatusBean.getRetryTimes() + 1;
				retryDataStatusBean.setRetryTimes(retryTimes);
				if (retryTimes == PropertiesLoader.getInteger("retry.times") && dataStatus == DataStatus.FAILED) {
					retryDataStatusBean.setStatus(DataStatus.FAILED_TOO_MANY_TIMES.getStatus());
				} else {
					retryDataStatusBean.setStatus(dataStatus.getStatus());
				}
				retryDataStatusBean.setException(exceptionStr);
				if (logData)
					retryDataStatusBean.setData(gson.toJson(message.getData()));
				
				interfaceDataStatusDao.update(retryDataStatusBean);
			} else {	// 首次发送时插入日志
				final InterfaceDataStatusBean interfaceDataStatus = new InterfaceDataStatusBean(message.getWsInterface().getName());
				interfaceDataStatus.setbPk(message.getPk());
				interfaceDataStatus.setbPkExt1(message.getPkExt1());
				interfaceDataStatus.setbPkExt2(message.getPkExt2());
				interfaceDataStatus.setException(exceptionStr);
				interfaceDataStatus.setStatus(dataStatus.getStatus());
				if (logData)
					interfaceDataStatus.setData(gson.toJson(message.getData()));
				
				interfaceDataStatusDao.insert(interfaceDataStatus);
			}
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
