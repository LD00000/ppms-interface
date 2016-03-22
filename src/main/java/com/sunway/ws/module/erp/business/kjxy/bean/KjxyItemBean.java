package com.sunway.ws.module.erp.business.kjxy.bean;

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
    "zecconh",
    "zebelp",
    "zitemtype",
    "matkl",
    "matnr",
    "maktx",
    "ktmng",
    "meins",
    "zmeins",
    "netpr",
    "znetpr",
    "zbinum",
    "zbifbnum",
    "zbdbz",
    "zyl1",
    "zyl2",
    "zyl3",
    "zyl4",
    "zyl5",
    "zyl6",
    "zyl7",
    "zyl8"
})
public class KjxyItemBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = 8706003514050561520L;

	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "ZECCONH")
    protected String zecconh;
    @XmlElement(name = "ZEBELP")
    protected String zebelp;
    @XmlElement(name = "ZITEMTYPE")
    protected String zitemtype;
    @XmlElement(name = "MATKL")
    protected String matkl;
    @XmlElement(name = "MATNR")
    protected String matnr;
    @XmlElement(name = "MAKTX")
    protected String maktx;
    @XmlElement(name = "KTMNG")
    protected String ktmng;
    @XmlElement(name = "MEINS")
    protected String meins;
    @XmlElement(name = "ZMEINS")
    protected String zmeins;
    @XmlElement(name = "NETPR")
    protected String netpr;
    @XmlElement(name = "ZNETPR")
    protected String znetpr;
    @XmlElement(name = "ZBINUM")
    protected String zbinum;
    @XmlElement(name = "ZBIFBNUM")
    protected String zbifbnum;
    @XmlElement(name = "ZBDBZ")
    protected String zbdbz;
    @XmlElement(name = "ZYL1")
    protected String zyl1;
    @XmlElement(name = "ZYL2")
    protected String zyl2;
    @XmlElement(name = "ZYL3")
    protected String zyl3;
    @XmlElement(name = "ZYL4")
    protected String zyl4;
    @XmlElement(name = "ZYL5")
    protected String zyl5;
    @XmlElement(name = "ZYL6")
    protected String zyl6;
    @XmlElement(name = "ZYL7")
    protected String zyl7;
    @XmlElement(name = "ZYL8")
    protected String zyl8;
    
	public String getZlineid() {
		return zlineid;
	}
	public void setZlineid(String zlineid) {
		this.zlineid = zlineid;
	}
	public String getZecconh() {
		return zecconh;
	}
	public void setZecconh(String zecconh) {
		this.zecconh = zecconh;
	}
	public String getZebelp() {
		return zebelp;
	}
	public void setZebelp(String zebelp) {
		this.zebelp = zebelp;
	}
	public String getZitemtype() {
		return zitemtype;
	}
	public void setZitemtype(String zitemtype) {
		this.zitemtype = zitemtype;
	}
	public String getMatkl() {
		return matkl;
	}
	public void setMatkl(String matkl) {
		this.matkl = matkl;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public String getKtmng() {
		return ktmng;
	}
	public void setKtmng(String ktmng) {
		this.ktmng = ktmng;
	}
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	public String getZmeins() {
		return zmeins;
	}
	public void setZmeins(String zmeins) {
		this.zmeins = zmeins;
	}
	public String getNetpr() {
		return netpr;
	}
	public void setNetpr(String netpr) {
		this.netpr = netpr;
	}
	public String getZnetpr() {
		return znetpr;
	}
	public void setZnetpr(String znetpr) {
		this.znetpr = znetpr;
	}
	public String getZbinum() {
		return zbinum;
	}
	public void setZbinum(String zbinum) {
		this.zbinum = zbinum;
	}
	public String getZbifbnum() {
		return zbifbnum;
	}
	public void setZbifbnum(String zbifbnum) {
		this.zbifbnum = zbifbnum;
	}
	public String getZbdbz() {
		return zbdbz;
	}
	public void setZbdbz(String zbdbz) {
		this.zbdbz = zbdbz;
	}
	public String getZyl1() {
		return zyl1;
	}
	public void setZyl1(String zyl1) {
		this.zyl1 = zyl1;
	}
	public String getZyl2() {
		return zyl2;
	}
	public void setZyl2(String zyl2) {
		this.zyl2 = zyl2;
	}
	public String getZyl3() {
		return zyl3;
	}
	public void setZyl3(String zyl3) {
		this.zyl3 = zyl3;
	}
	public String getZyl4() {
		return zyl4;
	}
	public void setZyl4(String zyl4) {
		this.zyl4 = zyl4;
	}
	public String getZyl5() {
		return zyl5;
	}
	public void setZyl5(String zyl5) {
		this.zyl5 = zyl5;
	}
	public String getZyl6() {
		return zyl6;
	}
	public void setZyl6(String zyl6) {
		this.zyl6 = zyl6;
	}
	public String getZyl7() {
		return zyl7;
	}
	public void setZyl7(String zyl7) {
		this.zyl7 = zyl7;
	}
	public String getZyl8() {
		return zyl8;
	}
	public void setZyl8(String zyl8) {
		this.zyl8 = zyl8;
	}
	
}
