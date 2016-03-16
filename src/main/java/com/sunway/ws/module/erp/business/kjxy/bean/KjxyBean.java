package com.sunway.ws.module.erp.business.kjxy.bean;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zlineid",
    "msgid",
    "strn",
    "bukrs",
    "ekorg",
    "ekotx",
    "zqytype",
    "ekgrp",
    "eknam",
    "werks",
    "wrname1",
    "zktmng1",
    "zktmng2",
    "zecconh",
    "sarem",
    "zecfwcode",
    "zecsigntype",
    "zecxyver",
    "zcmisod",
    "zbsart",
    "zqydw",
    "zqycs",
    "aedat",
    "zqynam",
    "lifnr",
    "zgysname",
    "zeclifnrd",
    "kdatb",
    "kdate",
    "dastm",
    "cgfs",
    "zbifbnum",
    "zpurty",
    "zcarrytyp",
    "zfjurl",
    "zremark",
    "zecponum",
    "zecpodocm",
    "mwskz",
    "ktwrt",
    "waers",
    "zecfwrate",
    "logsys",
    "zmmyl01",
    "zmmyl02",
    "zmmyl03"
})
@Table(name="i_erp_kjxy")
public class KjxyBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -7810235457436902809L;

	@XmlTransient
	private Long id;
	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "STRN")
    protected String strn;
    @XmlElement(name = "BUKRS")
    protected String bukrs;
    @XmlElement(name = "EKORG")
    protected String ekorg;
    @XmlElement(name = "EKOTX")
    protected String ekotx;
    @XmlElement(name = "ZQYTYPE")
    protected String zqytype;
    @XmlElement(name = "EKGRP")
    protected String ekgrp;
    @XmlElement(name = "EKNAM")
    protected String eknam;
    @XmlElement(name = "WERKS")
    protected String werks;
    @XmlElement(name = "WRNAME1")
    protected String wrname1;
    @XmlElement(name = "ZKTMNG1")
    protected String zktmng1;
    @XmlElement(name = "ZKTMNG2")
    protected String zktmng2;
    @XmlElement(name = "ZECCONH")
    protected String zecconh;
    @XmlElement(name = "SAREM")
    protected String sarem;
    @XmlElement(name = "ZECFWCODE")
    protected String zecfwcode;
    @XmlElement(name = "ZECSIGNTYPE")
    protected String zecsigntype;
    @XmlElement(name = "ZECXYVER")
    protected String zecxyver;
    @XmlElement(name = "ZCMISOD")
    protected String zcmisod;
    @XmlElement(name = "ZBSART")
    protected String zbsart;
    @XmlElement(name = "ZQYDW")
    protected String zqydw;
    @XmlElement(name = "ZQYCS")
    protected String zqycs;
    @XmlElement(name = "AEDAT")
    protected String aedat;
    @XmlElement(name = "ZQYNAM")
    protected String zqynam;
    @XmlElement(name = "LIFNR")
    protected String lifnr;
    @XmlElement(name = "ZGYSNAME")
    protected String zgysname;
    @XmlElement(name = "ZECLIFNRD")
    protected String zeclifnrd;
    @XmlElement(name = "KDATB")
    protected String kdatb;
    @XmlElement(name = "KDATE")
    protected String kdate;
    @XmlElement(name = "DASTM")
    protected String dastm;
    @XmlElement(name = "CGFS")
    protected String cgfs;
    @XmlElement(name = "ZBIFBNUM")
    protected String zbifbnum;
    @XmlElement(name = "ZPURTY")
    protected String zpurty;
    @XmlElement(name = "ZCARRYTYP")
    protected String zcarrytyp;
    @XmlElement(name = "ZFJURL")
    protected String zfjurl;
    @XmlElement(name = "ZREMARK")
    protected String zremark;
    @XmlElement(name = "ZECPONUM")
    protected String zecponum;
    @XmlElement(name = "ZECPODOCM")
    protected String zecpodocm;
    @XmlElement(name = "MWSKZ")
    protected String mwskz;
    @XmlElement(name = "KTWRT")
    protected String ktwrt;
    @XmlElement(name = "WAERS")
    protected String waers;
    @XmlElement(name = "ZECFWRATE")
    protected String zecfwrate;
    @XmlElement(name = "LOGSYS")
    protected String logsys;
    @XmlElement(name = "ZMMYL01")
    protected String zmmyl01;
    @XmlElement(name = "ZMMYL02")
    protected String zmmyl02;
    @XmlElement(name = "ZMMYL03")
    protected String zmmyl03;
    @XmlTransient
    private String status;
    
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
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getEkorg() {
		return ekorg;
	}
	public void setEkorg(String ekorg) {
		this.ekorg = ekorg;
	}
	public String getEkotx() {
		return ekotx;
	}
	public void setEkotx(String ekotx) {
		this.ekotx = ekotx;
	}
	public String getZqytype() {
		return zqytype;
	}
	public void setZqytype(String zqytype) {
		this.zqytype = zqytype;
	}
	public String getEkgrp() {
		return ekgrp;
	}
	public void setEkgrp(String ekgrp) {
		this.ekgrp = ekgrp;
	}
	public String getEknam() {
		return eknam;
	}
	public void setEknam(String eknam) {
		this.eknam = eknam;
	}
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getWrname1() {
		return wrname1;
	}
	public void setWrname1(String wrname1) {
		this.wrname1 = wrname1;
	}
	public String getZktmng1() {
		return zktmng1;
	}
	public void setZktmng1(String zktmng1) {
		this.zktmng1 = zktmng1;
	}
	public String getZktmng2() {
		return zktmng2;
	}
	public void setZktmng2(String zktmng2) {
		this.zktmng2 = zktmng2;
	}
	public String getZecconh() {
		return zecconh;
	}
	public void setZecconh(String zecconh) {
		this.zecconh = zecconh;
	}
	public String getSarem() {
		return sarem;
	}
	public void setSarem(String sarem) {
		this.sarem = sarem;
	}
	public String getZecfwcode() {
		return zecfwcode;
	}
	public void setZecfwcode(String zecfwcode) {
		this.zecfwcode = zecfwcode;
	}
	public String getZecsigntype() {
		return zecsigntype;
	}
	public void setZecsigntype(String zecsigntype) {
		this.zecsigntype = zecsigntype;
	}
	public String getZecxyver() {
		return zecxyver;
	}
	public void setZecxyver(String zecxyver) {
		this.zecxyver = zecxyver;
	}
	public String getZcmisod() {
		return zcmisod;
	}
	public void setZcmisod(String zcmisod) {
		this.zcmisod = zcmisod;
	}
	public String getZbsart() {
		return zbsart;
	}
	public void setZbsart(String zbsart) {
		this.zbsart = zbsart;
	}
	public String getZqydw() {
		return zqydw;
	}
	public void setZqydw(String zqydw) {
		this.zqydw = zqydw;
	}
	public String getZqycs() {
		return zqycs;
	}
	public void setZqycs(String zqycs) {
		this.zqycs = zqycs;
	}
	public String getAedat() {
		return aedat;
	}
	public void setAedat(String aedat) {
		this.aedat = aedat;
	}
	public String getZqynam() {
		return zqynam;
	}
	public void setZqynam(String zqynam) {
		this.zqynam = zqynam;
	}
	public String getLifnr() {
		return lifnr;
	}
	public void setLifnr(String lifnr) {
		this.lifnr = lifnr;
	}
	public String getZgysname() {
		return zgysname;
	}
	public void setZgysname(String zgysname) {
		this.zgysname = zgysname;
	}
	public String getZeclifnrd() {
		return zeclifnrd;
	}
	public void setZeclifnrd(String zeclifnrd) {
		this.zeclifnrd = zeclifnrd;
	}
	public String getKdatb() {
		return kdatb;
	}
	public void setKdatb(String kdatb) {
		this.kdatb = kdatb;
	}
	public String getKdate() {
		return kdate;
	}
	public void setKdate(String kdate) {
		this.kdate = kdate;
	}
	public String getDastm() {
		return dastm;
	}
	public void setDastm(String dastm) {
		this.dastm = dastm;
	}
	public String getCgfs() {
		return cgfs;
	}
	public void setCgfs(String cgfs) {
		this.cgfs = cgfs;
	}
	public String getZbifbnum() {
		return zbifbnum;
	}
	public void setZbifbnum(String zbifbnum) {
		this.zbifbnum = zbifbnum;
	}
	public String getZpurty() {
		return zpurty;
	}
	public void setZpurty(String zpurty) {
		this.zpurty = zpurty;
	}
	public String getZcarrytyp() {
		return zcarrytyp;
	}
	public void setZcarrytyp(String zcarrytyp) {
		this.zcarrytyp = zcarrytyp;
	}
	public String getZfjurl() {
		return zfjurl;
	}
	public void setZfjurl(String zfjurl) {
		this.zfjurl = zfjurl;
	}
	public String getZremark() {
		return zremark;
	}
	public void setZremark(String zremark) {
		this.zremark = zremark;
	}
	public String getZecponum() {
		return zecponum;
	}
	public void setZecponum(String zecponum) {
		this.zecponum = zecponum;
	}
	public String getZecpodocm() {
		return zecpodocm;
	}
	public void setZecpodocm(String zecpodocm) {
		this.zecpodocm = zecpodocm;
	}
	public String getMwskz() {
		return mwskz;
	}
	public void setMwskz(String mwskz) {
		this.mwskz = mwskz;
	}
	public String getKtwrt() {
		return ktwrt;
	}
	public void setKtwrt(String ktwrt) {
		this.ktwrt = ktwrt;
	}
	public String getWaers() {
		return waers;
	}
	public void setWaers(String waers) {
		this.waers = waers;
	}
	public String getZecfwrate() {
		return zecfwrate;
	}
	public void setZecfwrate(String zecfwrate) {
		this.zecfwrate = zecfwrate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
