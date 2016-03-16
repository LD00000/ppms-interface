package com.sunway.ws.core.exception;

/**
 * 客户端异常
 * 
 * @author lidong
 *
 */
public class ServerException extends RuntimeException {

	private static final long serialVersionUID = 5566841630899484880L;

	public ServerException(String msg) {
		super(msg);
	}

	public ServerException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public ServerException(Throwable throwable) {
		super(throwable);
	}
	
}
