package com.sunway.ws.core.consumer;

import java.io.Serializable;

import com.sunway.ws.module.WSInterface;

public class MessageExtInner implements Serializable {
	
	private static final long serialVersionUID = -6283681091757863704L;

	private WSInterface erpInterface;
	private String pk;
	private String pkExt1;
	private String pkExt2;
	private Object data;
	private Class<?> dataType;
	
	public boolean hasData() {
		return data != null && pk != null;
	}

	public WSInterface getErpInterface() {
		return erpInterface;
	}
	
	public void setErpInterface(WSInterface erpInterface) {
		this.erpInterface = erpInterface;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getPkExt1() {
		return pkExt1;
	}

	public void setPkExt1(String pkExt1) {
		this.pkExt1 = pkExt1;
	}

	public String getPkExt2() {
		return pkExt2;
	}

	public void setPkExt2(String pkExt2) {
		this.pkExt2 = pkExt2;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	public void setDataType(Class<?> dataType) {
		this.dataType = dataType;
	}
	
}
