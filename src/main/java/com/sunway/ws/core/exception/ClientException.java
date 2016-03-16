package com.sunway.ws.core.exception;

/**
 * 客户端异常
 * 
 * @author lidong
 *
 */
public class ClientException extends RuntimeException {

	private static final long serialVersionUID = 5566841630899484880L;

	public ClientException(String msg) {
		super(msg);
	}

	public ClientException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ClientException(Throwable throwable) {
		super(throwable);
	}
	
}
