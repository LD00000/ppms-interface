package com.sunway.ws.module.erp.business.feedback.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

/**
 * erp ���� log ������
 * 
 * @author lidong
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class BaseLog extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = -4080297343260765920L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlTransient
	private Long id;
	private String zlineid;	//
	@XmlTransient
	private String msheadid;	// 
	private String msgid;	// 
	private String logsys;	// 
	private String number;	// 
	private String type;	// 
	private String message;	// 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZlineid() {
		return zlineid;
	}
	public void setZlineid(String zlineid) {
		this.zlineid = zlineid;
	}
	public String getMsheadid() {
		return msheadid;
	}
	public void setMsheadid(String msheadid) {
		this.msheadid = msheadid;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getLogsys() {
		return logsys;
	}
	public void setLogsys(String logsys) {
		this.logsys = logsys;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
