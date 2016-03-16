package com.sunway.ws.core.bean;

import java.io.Serializable;

import javax.persistence.Transient;

/**
 * 基础 bean
 */
public abstract class BaseBean implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 7955845786112655992L;
	
}
