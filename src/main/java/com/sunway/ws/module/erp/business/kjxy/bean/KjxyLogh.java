package com.sunway.ws.module.erp.business.kjxy.bean;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

/**
 * erp 接口日志
 */
@Table(name="i_erp_log")
@XmlAccessorType(XmlAccessType.FIELD)
public class KjxyLogh extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = 2463333047384822545L;
	
	@XmlElement(name="ZLINEID")
	private String zlineid;
	@XmlElement(name="MSGID")
	private String msgid;
	@XmlElement(name="STRN")
	private String strn;
	@XmlElement(name="ZECCONH")
	private String zecconh;
	@XmlElement(name="ZECXYVER")
	private String zecxyver;
	@XmlElement(name="BUKRS")
	private String bukrs;
	@XmlElement(name="EBELN")
	private String ebeln;
	@XmlElement(name="FLAG")
	private String flag;
	@XmlElement(name="EREDT")
	private String eredt;
	@XmlElement(name="ZHTXT")
	private String zhtxt;
	@XmlElement(name="LOGSYS")
	private String logsys;
	@XmlElement(name="ZMMYL01")
	private String zmmyl01;
	@XmlElement(name="ZMMYL02")
	private String zmmyl02;
	@XmlElement(name="ZMMYL03")
	private String zmmyl03;
	
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
	public String getStrn() {
		return strn;
	}
	public void setStrn(String strn) {
		this.strn = strn;
	}
	public String getZecconh() {
		return zecconh;
	}
	public void setZecconh(String zecconh) {
		this.zecconh = zecconh;
	}
	public String getZecxyver() {
		return zecxyver;
	}
	public void setZecxyver(String zecxyver) {
		this.zecxyver = zecxyver;
	}
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getEbeln() {
		return ebeln;
	}
	public void setEbeln(String ebeln) {
		this.ebeln = ebeln;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getEredt() {
		return eredt;
	}
	public void setEredt(String eredt) {
		this.eredt = eredt;
	}
	public String getZhtxt() {
		return zhtxt;
	}
	public void setZhtxt(String zhtxt) {
		this.zhtxt = zhtxt;
	}
	public String getLogsys() {
		return logsys;
	}
	public void setLogsys(String logsys) {
		this.logsys = logsys;
	}
	public String getZmmyl01() {
		return zmmyl01;
	}
	public void setZmmyl01(String zmmyl01) {
		this.zmmyl01 = zmmyl01;
	}
	public String getZmmyl02() {
		return zmmyl02;
	}
	public void setZmmyl02(String zmmyl02) {
		this.zmmyl02 = zmmyl02;
	}
	public String getZmmyl03() {
		return zmmyl03;
	}
	public void setZmmyl03(String zmmyl03) {
		this.zmmyl03 = zmmyl03;
	}
	@Override
	public String toString() {
		return "KjxyLogh [zlineid=" + zlineid + ", msgid=" + msgid + ", strn=" + strn + ", zecconh=" + zecconh
				+ ", zecxyver=" + zecxyver + ", bukrs=" + bukrs + ", ebeln=" + ebeln + ", flag=" + flag + ", eredt="
				+ eredt + ", zhtxt=" + zhtxt + ", logsys=" + logsys + ", zmmyl01=" + zmmyl01 + ", zmmyl02=" + zmmyl02
				+ ", zmmyl03=" + zmmyl03 + "]";
	}

}
