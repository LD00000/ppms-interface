package com.sunway.ws.module.erp.business.ckd.bean;

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
    "ckdh",
    "ckdbc",
    "xh",
    "htbm",
    "htmxxh",
    "wbs",
    "wzbm",
    "jldw",
    "wzwh",
    "zdsl",
    "kcdd",
    "zddj",
    "zdje",
    "waers",
    "slv",
    "se",
    "yzf",
    "yzfse",
    "zf",
    "mxbz",
    "marianrkdmxid",
    "mariansmstid",
    "mariansmstcode",
    "wzlb",
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
public class CkdItemBean extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = 4972092352834591919L;
	
	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "RKDH")
    protected String ckdh;
    @XmlElement(name = "RKDBC")
    protected String ckdbc;
    @XmlElement(name = "XH")
    protected String xh;
    @XmlElement(name = "HTBM")
    protected String htbm;
    @XmlElement(name = "HTMXXH")
    protected String htmxxh;
    @XmlElement(name = "WBS")
    protected String wbs;
    @XmlElement(name = "WZBM")
    protected String wzbm;
    @XmlElement(name = "JLDW")
    protected String jldw;
    @XmlElement(name = "WZWH")
    protected String wzwh;
    @XmlElement(name = "ZDSL")
    protected String zdsl;
    @XmlElement(name = "KCDD")
    protected String kcdd;
    @XmlElement(name = "ZDDJ")
    protected String zddj;
    @XmlElement(name = "ZDJE")
    protected String zdje;
    @XmlElement(name = "WAERS")
    protected String waers;
    @XmlElement(name = "SLV")
    protected String slv;
    @XmlElement(name = "SE")
    protected String se;
    @XmlElement(name = "YZF")
    protected String yzf;
    @XmlElement(name = "YZFSE")
    protected String yzfse;
    @XmlElement(name = "ZF")
    protected String zf;
    @XmlElement(name = "MXBZ")
    protected String mxbz;
    @XmlElement(name = "MARIANRKDMXID")
    protected String marianrkdmxid;
    @XmlElement(name = "MARIANSMST_ID")
    protected String mariansmstid;
    @XmlElement(name = "MARIANSMST_CODE")
    protected String mariansmstcode;
    @XmlElement(name = "WZLB")
    protected String wzlb;
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
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getHtbm() {
		return htbm;
	}
	public void setHtbm(String htbm) {
		this.htbm = htbm;
	}
	public String getHtmxxh() {
		return htmxxh;
	}
	public void setHtmxxh(String htmxxh) {
		this.htmxxh = htmxxh;
	}
	public String getWbs() {
		return wbs;
	}
	public void setWbs(String wbs) {
		this.wbs = wbs;
	}
	public String getWzbm() {
		return wzbm;
	}
	public void setWzbm(String wzbm) {
		this.wzbm = wzbm;
	}
	public String getJldw() {
		return jldw;
	}
	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
	public String getWzwh() {
		return wzwh;
	}
	public void setWzwh(String wzwh) {
		this.wzwh = wzwh;
	}
	public String getZdsl() {
		return zdsl;
	}
	public void setZdsl(String zdsl) {
		this.zdsl = zdsl;
	}
	public String getZddj() {
		return zddj;
	}
	public void setZddj(String zddj) {
		this.zddj = zddj;
	}
	public String getZdje() {
		return zdje;
	}
	public void setZdje(String zdje) {
		this.zdje = zdje;
	}
	public String getWaers() {
		return waers;
	}
	public void setWaers(String waers) {
		this.waers = waers;
	}
	public String getSlv() {
		return slv;
	}
	public void setSlv(String slv) {
		this.slv = slv;
	}
	public String getSe() {
		return se;
	}
	public void setSe(String se) {
		this.se = se;
	}
	public String getYzf() {
		return yzf;
	}
	public void setYzf(String yzf) {
		this.yzf = yzf;
	}
	public String getYzfse() {
		return yzfse;
	}
	public void setYzfse(String yzfse) {
		this.yzfse = yzfse;
	}
	public String getZf() {
		return zf;
	}
	public void setZf(String zf) {
		this.zf = zf;
	}
	public String getMxbz() {
		return mxbz;
	}
	public void setMxbz(String mxbz) {
		this.mxbz = mxbz;
	}
	public String getMarianrkdmxid() {
		return marianrkdmxid;
	}
	public void setMarianrkdmxid(String marianrkdmxid) {
		this.marianrkdmxid = marianrkdmxid;
	}
	public String getMariansmstid() {
		return mariansmstid;
	}
	public void setMariansmstid(String mariansmstid) {
		this.mariansmstid = mariansmstid;
	}
	public String getMariansmstcode() {
		return mariansmstcode;
	}
	public void setMariansmstcode(String mariansmstcode) {
		this.mariansmstcode = mariansmstcode;
	}
	public String getWzlb() {
		return wzlb;
	}
	public void setWzlb(String wzlb) {
		this.wzlb = wzlb;
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
	public String getCkdh() {
		return ckdh;
	}
	public void setCkdh(String ckdh) {
		this.ckdh = ckdh;
	}
	public String getCkdbc() {
		return ckdbc;
	}
	public void setCkdbc(String ckdbc) {
		this.ckdbc = ckdbc;
	}
	public String getKcdd() {
		return kcdd;
	}
	public void setKcdd(String kcdd) {
		this.kcdd = kcdd;
	}

}
