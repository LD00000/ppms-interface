package com.sunway.ws.core.consumer;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private final InterfaceDataStatusDaoImpl interfaceDataStatusDao = new InterfaceDataStatusDaoImpl();
	
	private MessageListener messageListener;
	private MessageExtInner message;
	private boolean persistLog;	// 是否记录日志
	private InterfaceDataStatusBean retryDataStatusBean;	// 要重发的数据
	
	public WSDefaultConsumer(WSInterface wsInterface) {
		this.message = new MessageExtInner();
		this.message.setErpInterface(wsInterface);
		this.persistLog = true;
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
			return;
		
		String exceptionStr = "";
		DataStatus dataStatus = DataStatus.FAILED;
		
		try {
			dataStatus = messageListener.consumeMessage(message);
			logger.info("{}, {} 发送成功...", message.getErpInterface().getName(), message.getPk());
		} catch (Exception e) {
			logger.error(message.getErpInterface().getName() + " consumer error...", e);
			exceptionStr = ExceptionUtils.getStackTrace(e);
		}
		
		if (persistLog) {
			if (this.retryDataStatusBean != null) {
				final Integer retryTimes = retryDataStatusBean.getRetryTimes() + 1;
				retryDataStatusBean.setRetryTimes(retryTimes);
				if (retryTimes == PropertiesLoader.getInteger("retry.times"))
					retryDataStatusBean.setStatus(DataStatus.FAILED_TOO_MANY_TIMES.getStatus());
				
				interfaceDataStatusDao.update(retryDataStatusBean);
			} else {
				final InterfaceDataStatusBean interfaceDataStatus = new InterfaceDataStatusBean(message.getErpInterface().getName());
				interfaceDataStatus.setbPk(message.getPk());
				interfaceDataStatus.setbPkExt1(message.getPkExt1());
				interfaceDataStatus.setbPkExt2(message.getPkExt2());
				interfaceDataStatus.setException(exceptionStr);
				interfaceDataStatus.setStatus(dataStatus.getStatus());
				
				interfaceDataStatusDao.insert(interfaceDataStatus);
			}
		}
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
	 * 重发数据</br> 
	 * 开启日志的情况下, 会增加重试次数
	 * 
	 * @param retryDataStatusBean
	 * @return
	 */
	public WSDefaultConsumer retry(InterfaceDataStatusBean retryDataStatusBean) {
		this.retryDataStatusBean = retryDataStatusBean;
		return this;
	}

}
