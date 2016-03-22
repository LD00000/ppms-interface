package com.sunway.ws.module.erp.business.lcb.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zbukrs",
    "pspid",
    "posid",
    "qgdbm",
    "marianqgdbm",
    "banfn",
    "zekgrp",
    "gswrt",
    "ernam",
    "erdat",
    "aenam",
    "aedat",
    "zmmyl001",
    "zmmyl002",
    "zmmyl003",
    "zmmyl004",
    "zmmyl005"
})
public class LcbBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -8977259829830448604L;

	@XmlElement(name = "ZBUKRS")
    protected String zbukrs;
    @XmlElement(name = "PSPID")
    protected String pspid;
    @XmlElement(name = "POSID")
    protected String posid;
    @XmlElement(name = "QGDBM")
    protected String qgdbm;
    @XmlElement(name = "MARIANQGDBM")
    protected String marianqgdbm;
    @XmlElement(name = "BANFN")
    protected String banfn;
    @XmlElement(name = "ZEKGRP")
    protected String zekgrp;
    @XmlElement(name = "GSWRT")
    protected String gswrt;
    @XmlElement(name = "ERNAM")
    protected String ernam;
    @XmlElement(name = "ERDAT")
    protected String erdat;
    @XmlElement(name = "AENAM")
    protected String aenam;
    @XmlElement(name = "AEDAT")
    protected String aedat;
    @XmlElement(name = "ZMMYL001")
    protected String zmmyl001;
    @XmlElement(name = "ZMMYL002")
    protected String zmmyl002;
    @XmlElement(name = "ZMMYL003")
    protected String zmmyl003;
    @XmlElement(name = "ZMMYL004")
    protected String zmmyl004;
    @XmlElement(name = "ZMMYL005")
    protected String zmmyl005;
    
	public String getZbukrs() {
		return zbukrs;
	}
	public void setZbukrs(String zbukrs) {
		this.zbukrs = zbukrs;
	}
	public String getPspid() {
		return pspid;
	}
	public void setPspid(String pspid) {
		this.pspid = pspid;
	}
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getQgdbm() {
		return qgdbm;
	}
	public void setQgdbm(String qgdbm) {
		this.qgdbm = qgdbm;
	}
	public String getMarianqgdbm() {
		return marianqgdbm;
	}
	public void setMarianqgdbm(String marianqgdbm) {
		this.marianqgdbm = marianqgdbm;
	}
	public String getBanfn() {
		return banfn;
	}
	public void setBanfn(String banfn) {
		this.banfn = banfn;
	}
	public String getZekgrp() {
		return zekgrp;
	}
	public void setZekgrp(String zekgrp) {
		this.zekgrp = zekgrp;
	}
	public String getGswrt() {
		return gswrt;
	}
	public void setGswrt(String gswrt) {
		this.gswrt = gswrt;
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
	public String getAenam() {
		return aenam;
	}
	public void setAenam(String aenam) {
		this.aenam = aenam;
	}
	public String getAedat() {
		return aedat;
	}
	public void setAedat(String aedat) {
		this.aedat = aedat;
	}
	public String getZmmyl001() {
		return zmmyl001;
	}
	public void setZmmyl001(String zmmyl001) {
		this.zmmyl001 = zmmyl001;
	}
	public String getZmmyl002() {
		return zmmyl002;
	}
	public void setZmmyl002(String zmmyl002) {
		this.zmmyl002 = zmmyl002;
	}
	public String getZmmyl003() {
		return zmmyl003;
	}
	public void setZmmyl003(String zmmyl003) {
		this.zmmyl003 = zmmyl003;
	}
	public String getZmmyl004() {
		return zmmyl004;
	}
	public void setZmmyl004(String zmmyl004) {
		this.zmmyl004 = zmmyl004;
	}
	public String getZmmyl005() {
		return zmmyl005;
	}
	public void setZmmyl005(String zmmyl005) {
		this.zmmyl005 = zmmyl005;
	}

}
