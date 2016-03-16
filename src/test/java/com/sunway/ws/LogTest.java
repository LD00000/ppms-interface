package com.sunway.ws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest {
	
	private static final Logger logger = LogManager.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("1",e);
			logger.info("-----------------------");
			throw new RuntimeException(e);
		}
	}

}
