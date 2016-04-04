package com.sunway.ws.module.erp.business.cght.bean;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class CghtQtfyBean implements Serializable {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -3614027440192878247L;
	
	@XmlElement(name = "ZLINEID")
	private String zlineid;
	@XmlElement(name = "HTBM")
	private String htbm;
	@XmlElement(name = "XH")
	private String xh;
	@XmlElement(name = "FYLXBM")
	private String fylxbm;
	@XmlElement(name = "FYJE")
	private String fyje;
	@XmlElement(name = "BZ")
	private String bz;
	@XmlElement(name = "ZMMYL01")
	private String zmmyl01;
	@XmlElement(name = "ZMMYL02")
	private String zmmyl02;
	@XmlElement(name = "ZMMYL03")
	private String zmmyl03;
	@XmlElement(name = "ZMMYL04")
	private String zmmyl04;
	@XmlElement(name = "ZMMYL05")
	private String zmmyl05;
	
	public String getZlineid() {
		return zlineid;
	}
	public void setZlineid(String zlineid) {
		this.zlineid = zlineid;
	}
	public String getHtbm() {
		return htbm;
	}
	public void setHtbm(String htbm) {
		this.htbm = htbm;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getFylxbm() {
		return fylxbm;
	}
	public void setFylxbm(String fylxbm) {
		this.fylxbm = fylxbm;
	}
	public String getFyje() {
		return fyje;
	}
	public void setFyje(String fyje) {
		this.fyje = fyje;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
	public String getZmmyl04() {
		return zmmyl04;
	}
	public void setZmmyl04(String zmmyl04) {
		this.zmmyl04 = zmmyl04;
	}
	public String getZmmyl05() {
		return zmmyl05;
	}
	public void setZmmyl05(String zmmyl05) {
		this.zmmyl05 = zmmyl05;
	}

}
