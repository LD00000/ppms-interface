package com.sunway.ws.module.erp.business.kjxy.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
public class KjxyLogl extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = 375564241479493725L;
	
	@XmlElement(name="ZLINEID")
	private String zlineid;
	@XmlElement(name="ZEBELP")
	private String zebelp;
	@XmlElement(name="EBELP")
	private String ebelp;
	@XmlElement(name="ZLFLAG")
	private String zlflag;
	@XmlElement(name="ZLTXT")
	private String zltxt;
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
	public String getZebelp() {
		return zebelp;
	}
	public void setZebelp(String zebelp) {
		this.zebelp = zebelp;
	}
	public String getEbelp() {
		return ebelp;
	}
	public void setEbelp(String ebelp) {
		this.ebelp = ebelp;
	}
	public String getZlflag() {
		return zlflag;
	}
	public void setZlflag(String zlflag) {
		this.zlflag = zlflag;
	}
	public String getZltxt() {
		return zltxt;
	}
	public void setZltxt(String zltxt) {
		this.zltxt = zltxt;
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

}
