package com.sunway.ws.module.erp.business.rkd.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
public class RkdLog extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = -4296133047202852603L;

	private String zlineid;
	private String msgid;
	private String logsys;
	private String zrkdh;
	private String zrkdbc;
	private String zxhrk;
	private String ebeln;
	private String ebelp;
	private String mblnr;
	private String mjahr;
	private String zeile;
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
	public String getZrkdh() {
		return zrkdh;
	}
	public void setZrkdh(String zrkdh) {
		this.zrkdh = zrkdh;
	}
	public String getZrkdbc() {
		return zrkdbc;
	}
	public void setZrkdbc(String zrkdbc) {
		this.zrkdbc = zrkdbc;
	}
	public String getZxhrk() {
		return zxhrk;
	}
	public void setZxhrk(String zxhrk) {
		this.zxhrk = zxhrk;
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
	public String getMblnr() {
		return mblnr;
	}
	public void setMblnr(String mblnr) {
		this.mblnr = mblnr;
	}
	public String getMjahr() {
		return mjahr;
	}
	public void setMjahr(String mjahr) {
		this.mjahr = mjahr;
	}
	public String getZeile() {
		return zeile;
	}
	public void setZeile(String zeile) {
		this.zeile = zeile;
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
