package com.sunway.ws.core.consumer;

import com.sunway.ws.module.common.DataStatus;

public interface MessageListener {
	
	/**
	 * 消费消息
	 * 
	 * @param message
	 * @return 数据状态
	 */
	public DataStatus consumeMessage(final MessageExtInner message);

}
