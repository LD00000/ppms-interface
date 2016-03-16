package com.sunway.ws.module.erp.business.cght.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

/**
 * 反馈 log
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class CghtLog extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = -1845883320963272405L;

	private String id;
	private String zlineid;
	private String msgid;
	private String logsys;
	private String zhtbm;
	private String zhtxh;
	private String ebeln;
	private String ebelp;
	private String ernam;
	private String erdat;
	private String erzet;
	private String number;
	private String type;
	private String message;
	
	public String getZlineid() {
		return zlineid;
	}
	public void setZlineid(String zlineid) {
		this.zlineid = zlineid;
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
	public String getZhtbm() {
		return zhtbm;
	}
	public void setZhtbm(String zhtbm) {
		this.zhtbm = zhtbm;
	}
	public String getZhtxh() {
		return zhtxh;
	}
	public void setZhtxh(String zhtxh) {
		this.zhtxh = zhtxh;
	}
	public String getEbeln() {
		return ebeln;
	}
	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}
	public String getEbelp() {
		return ebelp;
	}
	public void setEbelp(String ebelp) {
		this.ebelp = ebelp;
	}
	public String getErnam() {
		return ernam;
	}
	public void setErnam(String ernam) {
		this.ernam = ernam;
	}
	public String getErdat() {
		return erdat;
	}
	public void setErdat(String erdat) {
		this.erdat = erdat;
	}
	public String getErzet() {
		return erzet;
	}
	public void setErzet(String erzet) {
		this.erzet = erzet;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
