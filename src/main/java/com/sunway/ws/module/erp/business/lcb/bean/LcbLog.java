package com.sunway.ws.module.erp.business.lcb.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlTransient
	private Long id;
	private String qgdbm;
	private String type;
	private String message;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	@Override
	public String toString() {
		return "LcbLog [id=" + id + ", qgdbm=" + qgdbm + ", type=" + type + ", message=" + message + "]";
	}

}
