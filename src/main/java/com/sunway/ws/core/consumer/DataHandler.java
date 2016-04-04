package com.sunway.ws.core.consumer;

public interface DataHandler {
	
	public MessageExtInner handleMessage(MessageExtInner message);

}
