package com.sunway.ws.module.erp.business.lcb.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
public class LcbLog extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = -6355171025406911462L;
	
	private String qgdbm;
	private String type;
	private String message;
	
	public String getQgdbm() {
		return qgdbm;
	}
	public void setQgdbm(String qgdbm) {
		this.qgdbm = qgdbm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
