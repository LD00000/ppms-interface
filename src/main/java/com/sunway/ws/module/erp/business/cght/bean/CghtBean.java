package com.sunway.ws.module.erp.business.cght.bean;

import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zlineid",
    "msgid",
    "logsys",
    "htbm",
    "flag",
    "sfcg",
    "ywlxbz",
    "stats",
    "htbh",
    "htbc",
    "htmc",
    "htwb",
    "htlx",
    "wzmc",
    "jhdd",
    "xmbm",
    "xmmc",
    "htdj",
    "wscgbz",
    "htzbj",
    "htyfk",
    "fromfabz",
    "ysfsbm",
    "cgmsbm",
    "zcgmsms",
    "jhfsbm",
    "htzje",
    "mxzje",
    "rmbhv",
    "zkje",
    "rmbje",
    "qdsj",
    "sxrq",
    "yxrq",
    "zdrbm",
    "bukrs",
    "ekorg",
    "ekgrp",
    "werks",
    "zzbm",
    "cmisod",
    "zbukrs",
    "zekgrp",
    "zmmyl01",
    "zmmyl02",
    "zmmyl03",
    "zmmyl04",
    "zmmyl05",
    "zmmyl06",
    "zmmyl07",
    "zmmyl08",
    "zmmyl09",
    "zmmyl10"
})
public class CghtBean {

	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "LOGSYS")
    protected String logsys;
    @XmlElement(name = "HTBM")
    protected String htbm;
    @XmlElement(name = "STATS")
    protected String stats;
    @XmlElement(name = "HTBH")
    protected String htbh;
    @XmlElement(name = "HTBC")
    protected String htbc;
    @XmlElement(name = "HTMC")
    protected String htmc;
    @XmlElement(name = "HTWB")
    @Lob
    protected String htwb;
    @XmlElement(name = "HTLX")
    protected String htlx;
    @XmlElement(name = "WZMC")
    protected String wzmc;
    @XmlElement(name = "JHDD")
    protected String jhdd;
    @XmlElement(name = "XMBM")
    protected String xmbm;
    @XmlElement(name = "XMMC")
    protected String xmmc;
    @XmlElement(name = "HTDJ")
    protected String htdj;
    @XmlElement(name = "WSCGBZ")
    protected String wscgbz;
    @XmlElement(name = "HTZBJ")
    protected String htzbj;
    @XmlElement(name = "HTYFK")
    protected String htyfk;
    @XmlElement(name = "FROMFABZ")
    protected String fromfabz;
    @XmlElement(name = "YSFSBM")
    protected String ysfsbm;
    @XmlElement(name = "CGMSBM")
    protected String cgmsbm;
    @XmlElement(name = "ZCGMSMS")
    protected String zcgmsms;
    @XmlElement(name = "JHFSBM")
    protected String jhfsbm;
    @XmlElement(name = "HTZJE")
    protected String htzje;
    @XmlElement(name = "MXZJE")
    protected String mxzje;
    @XmlElement(name = "RMBHV")
    protected String rmbhv;
    @XmlElement(name = "ZKJE")
    protected String zkje;
    @XmlElement(name = "RMBJE")
    protected String rmbje;
    @XmlElement(name = "QDSJ")
    protected String qdsj;
    @XmlElement(name = "SXRQ")
    protected String sxrq;
    @XmlElement(name = "YXRQ")
    protected String yxrq;
    @XmlElement(name = "ZDRBM")
    protected String zdrbm;
    @XmlElement(name = "BUKRS")
    protected String bukrs;
    @XmlElement(name = "EKORG")
    protected String ekorg;
    @XmlElement(name = "EKGRP")
    protected String ekgrp;
    @XmlElement(name = "WERKS")
    protected String werks;
    @XmlElement(name = "ZZBM")
    protected String zzbm;
    @XmlElement(name = "CMISOD")
    protected String cmisod;
    @XmlElement(name = "ZBUKRS")
    protected String zbukrs;
    @XmlElement(name = "ZEKGRP")
    protected String zekgrp;
    @XmlElement(name = "SFCG")
    protected String sfcg;
    @XmlElement(name = "FLAG")
    protected String flag;
    @XmlElement(name = "YWLXBZ")
    protected String ywlxbz;
    @XmlElement(name = "ZMMYL01")
    protected String zmmyl01;
    @XmlElement(name = "ZMMYL02")
    protected String zmmyl02;
    @XmlElement(name = "ZMMYL03")
    protected String zmmyl03;
    @XmlElement(name = "ZMMYL04")
    protected String zmmyl04;
    @XmlElement(name = "ZMMYL05")
    protected String zmmyl05;
    @XmlElement(name = "ZMMYL06")
    protected String zmmyl06;
    @XmlElement(name = "ZMMYL07")
    protected String zmmyl07;
    @XmlElement(name = "ZMMYL08")
    protected String zmmyl08;
    @XmlElement(name = "ZMMYL09")
    protected String zmmyl09;
    @XmlElement(name = "ZMMYL10")
    protected String zmmyl10;
    
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
	public String getHtbm() {
		return htbm;
	}
	public void setHtbm(String htbm) {
		this.htbm = htbm;
	}
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getHtbh() {
		return htbh;
	}
	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}
	public String getHtbc() {
		return htbc;
	}
	public void setHtbc(String htbc) {
		this.htbc = htbc;
	}
	public String getHtmc() {
		return htmc;
	}
	public void setHtmc(String htmc) {
		this.htmc = htmc;
	}
	public String getHtwb() {
		return htwb;
	}
	public void setHtwb(String htwb) {
		this.htwb = htwb;
	}
	public String getHtlx() {
		return htlx;
	}
	public void setHtlx(String htlx) {
		this.htlx = htlx;
	}
	public String getWzmc() {
		return wzmc;
	}
	public void setWzmc(String wzmc) {
		this.wzmc = wzmc;
	}
	public String getJhdd() {
		return jhdd;
	}
	public void setJhdd(String jhdd) {
		this.jhdd = jhdd;
	}
	public String getXmbm() {
		return xmbm;
	}
	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}
	public String getXmmc() {
		return xmmc;
	}
	public void setXmmc(String xmmc) {
		this.xmmc = xmmc;
	}
	public String getHtdj() {
		return htdj;
	}
	public void setHtdj(String htdj) {
		this.htdj = htdj;
	}
	public String getWscgbz() {
		return wscgbz;
	}
	public void setWscgbz(String wscgbz) {
		this.wscgbz = wscgbz;
	}
	public String getHtzbj() {
		return htzbj;
	}
	public void setHtzbj(String htzbj) {
		this.htzbj = htzbj;
	}
	public String getHtyfk() {
		return htyfk;
	}
	public void setHtyfk(String htyfk) {
		this.htyfk = htyfk;
	}
	public String getFromfabz() {
		return fromfabz;
	}
	public void setFromfabz(String fromfabz) {
		this.fromfabz = fromfabz;
	}
	public String getYsfsbm() {
		return ysfsbm;
	}
	public void setYsfsbm(String ysfsbm) {
		this.ysfsbm = ysfsbm;
	}
	public String getCgmsbm() {
		return cgmsbm;
	}
	public void setCgmsbm(String cgmsbm) {
		this.cgmsbm = cgmsbm;
	}
	public String getZcgmsms() {
		return zcgmsms;
	}
	public void setZcgmsms(String zcgmsms) {
		this.zcgmsms = zcgmsms;
	}
	public String getJhfsbm() {
		return jhfsbm;
	}
	public void setJhfsbm(String jhfsbm) {
		this.jhfsbm = jhfsbm;
	}
	public String getHtzje() {
		return htzje;
	}
	public void setHtzje(String htzje) {
		this.htzje = htzje;
	}
	public String getMxzje() {
		return mxzje;
	}
	public void setMxzje(String mxzje) {
		this.mxzje = mxzje;
	}
	public String getRmbhv() {
		return rmbhv;
	}
	public void setRmbhv(String rmbhv) {
		this.rmbhv = rmbhv;
	}
	public String getZkje() {
		return zkje;
	}
	public void setZkje(String zkje) {
		this.zkje = zkje;
	}
	public String getRmbje() {
		return rmbje;
	}
	public void setRmbje(String rmbje) {
		this.rmbje = rmbje;
	}
	public String getQdsj() {
		return qdsj;
	}
	public void setQdsj(String qdsj) {
		this.qdsj = qdsj;
	}
	public String getSxrq() {
		return sxrq;
	}
	public void setSxrq(String sxrq) {
		this.sxrq = sxrq;
	}
	public String getYxrq() {
		return yxrq;
	}
	public void setYxrq(String yxrq) {
		this.yxrq = yxrq;
	}
	public String getZdrbm() {
		return zdrbm;
	}
	public void setZdrbm(String zdrbm) {
		this.zdrbm = zdrbm;
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
	public String getEkgrp() {
		return ekgrp;
	}
	public void setEkgrp(String ekgrp) {
		this.ekgrp = ekgrp;
	}
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getZzbm() {
		return zzbm;
	}
	public void setZzbm(String zzbm) {
		this.zzbm = zzbm;
	}
	public String getCmisod() {
		return cmisod;
	}
	public void setCmisod(String cmisod) {
		this.cmisod = cmisod;
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
	public String getZmmyl06() {
		return zmmyl06;
	}
	public void setZmmyl06(String zmmyl06) {
		this.zmmyl06 = zmmyl06;
	}
	public String getZmmyl07() {
		return zmmyl07;
	}
	public void setZmmyl07(String zmmyl07) {
		this.zmmyl07 = zmmyl07;
	}
	public String getZmmyl08() {
		return zmmyl08;
	}
	public void setZmmyl08(String zmmyl08) {
		this.zmmyl08 = zmmyl08;
	}
	public String getZmmyl09() {
		return zmmyl09;
	}
	public void setZmmyl09(String zmmyl09) {
		this.zmmyl09 = zmmyl09;
	}
	public String getZmmyl10() {
		return zmmyl10;
	}
	public void setZmmyl10(String zmmyl10) {
		this.zmmyl10 = zmmyl10;
	}
	public String getZekgrp() {
		return zekgrp;
	}
	public void setZekgrp(String zekgrp) {
		this.zekgrp = zekgrp;
	}
	public String getZbukrs() {
		return zbukrs;
	}
	public void setZbukrs(String zbukrs) {
		this.zbukrs = zbukrs;
	}
	public String getSfcg() {
		return sfcg;
	}
	public void setSfcg(String sfcg) {
		this.sfcg = sfcg;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getYwlxbz() {
		return ywlxbz;
	}
	public void setYwlxbz(String ywlxbz) {
		this.ywlxbz = ywlxbz;
	}
	
}
