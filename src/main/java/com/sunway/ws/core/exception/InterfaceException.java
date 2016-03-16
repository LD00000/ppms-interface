package com.sunway.ws.core.exception;

public class InterfaceException extends RuntimeException {

	private static final long serialVersionUID = -4767502902234336125L;

	public InterfaceException(String msg) {
		super(msg);
	}

	public InterfaceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public InterfaceException(Throwable throwable) {
		super(throwable);
	}
	
}
