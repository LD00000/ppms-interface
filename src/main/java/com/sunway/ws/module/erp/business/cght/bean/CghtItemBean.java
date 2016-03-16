package com.sunway.ws.module.erp.business.cght.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;

@Table(name="i_erp_cght_item")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zlineid",
    "htbm",
    "xh",
    "qgdbm",
    "qgdxh",
    "qgdms",
    "ppmsqgd",
    "ppmsxh",
    "wzbm",
    "zwzbm",
    "wzmc",
    "ggxh",
    "htsl",
    "jldw",
    "dj",
    "htyf",
    "htzf",
    "otherfee",
    "jebzbm",
    "mwskz",
    "kjxybh",
    "jyl",
    "jhrq",
    "phsb",
    "wzwh",
    "bz",
    "cz",
    "dysm",
    "dz",
    "sjsl",
    "zldw",
    "rliid",
    "zz",
    "ebeln",
    "ebelp",
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
public class CghtItemBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -9189487826369373294L;
	
	@Id
	@XmlTransient
	private Long id;
	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "HTBM")
    protected String htbm;
    @XmlElement(name = "XH")
    protected String xh;
    @XmlElement(name = "WZBM")
    protected String wzbm;
    @XmlElement(name = "ZWZBM")
    protected String zwzbm;
    @XmlElement(name = "WZMC")
    protected String wzmc;
    @XmlElement(name = "GGXH")
    protected String ggxh;
    @XmlElement(name = "HTSL")
    protected String htsl;
    @XmlElement(name = "JLDW")
    protected String jldw;
    @XmlElement(name = "DJ")
    protected String dj;
    @XmlElement(name = "HTYF")
    protected String htyf;
    @XmlElement(name = "HTZF")
    protected String htzf;
    @XmlElement(name = "OTHER_FEE")
    protected String otherfee;
    @XmlElement(name = "JEBZBM")
    protected String jebzbm;
    @XmlElement(name = "MWSKZ")
    protected String mwskz;
    @XmlElement(name = "KJXYBH")
    protected String kjxybh;
    @XmlElement(name = "JYL")
    protected String jyl;
    @XmlElement(name = "JHRQ")
    protected String jhrq;
    @XmlElement(name = "PHSB")
    protected String phsb;
    @XmlElement(name = "WZWH")
    protected String wzwh;
    @XmlElement(name = "BZ")
    protected String bz;
    @XmlElement(name = "CZ")
    protected String cz;
    @XmlElement(name = "DYSM")
    protected String dysm;
    @XmlElement(name = "DZ")
    protected String dz;
    @XmlElement(name = "SJSL")
    protected String sjsl;
    @XmlElement(name = "ZLDW")
    protected String zldw;
    @XmlElement(name = "RLI_ID")
    protected String rliid;
    @XmlElement(name = "ZZ")
    protected String zz;
    @XmlElement(name = "EBELN")
    protected String ebeln;
    @XmlElement(name = "EBELP")
    protected String ebelp;
    @XmlElement(name = "QGDBM")
    protected String qgdbm;
    @XmlElement(name = "QGDXH")
    protected String qgdxh;
    @XmlElement(name = "QGDMS")
    protected String qgdms;
    @XmlElement(name = "PPMSQGD")
    private String ppmsqgd;
    @XmlElement(name = "PPMSXH")
    private String ppmsxh;
    @Transient
    @XmlElement(name = "ZMMYL01")
    protected String zmmyl01;
    @Transient
    @XmlElement(name = "ZMMYL02")
    protected String zmmyl02;
    @Transient
    @XmlElement(name = "ZMMYL03")
    protected String zmmyl03;
    @Transient
    @XmlElement(name = "ZMMYL04")
    protected String zmmyl04;
    @Transient
    @XmlElement(name = "ZMMYL05")
    protected String zmmyl05;
    @Transient
    @XmlElement(name = "ZMMYL06")
    protected String zmmyl06;
    @Transient
    @XmlElement(name = "ZMMYL07")
    protected String zmmyl07;
    @Transient
    @XmlElement(name = "ZMMYL08")
    protected String zmmyl08;
    @Transient
    @XmlElement(name = "ZMMYL09")
    protected String zmmyl09;
    @Transient
    @XmlElement(name = "ZMMYL10")
    protected String zmmyl10;
    @XmlTransient
    private Long headId;
    
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
	public String getWzbm() {
		return wzbm;
	}
	public void setWzbm(String wzbm) {
		this.wzbm = wzbm;
	}
	public String getZwzbm() {
		return zwzbm;
	}
	public void setZwzbm(String zwzbm) {
		this.zwzbm = zwzbm;
	}
	public String getWzmc() {
		return wzmc;
	}
	public void setWzmc(String wzmc) {
		this.wzmc = wzmc;
	}
	public String getGgxh() {
		return ggxh;
	}
	public void setGgxh(String ggxh) {
		this.ggxh = ggxh;
	}
	public String getHtsl() {
		return htsl;
	}
	public void setHtsl(String htsl) {
		this.htsl = htsl;
	}
	public String getJldw() {
		return jldw;
	}
	public void setJldw(String jldw) {
		this.jldw = jldw;
	}
	public String getDj() {
		return dj;
	}
	public void setDj(String dj) {
		this.dj = dj;
	}
	public String getHtyf() {
		return htyf;
	}
	public void setHtyf(String htyf) {
		this.htyf = htyf;
	}
	public String getHtzf() {
		return htzf;
	}
	public void setHtzf(String htzf) {
		this.htzf = htzf;
	}
	public String getOtherfee() {
		return otherfee;
	}
	public void setOtherfee(String otherfee) {
		this.otherfee = otherfee;
	}
	public String getJebzbm() {
		return jebzbm;
	}
	public void setJebzbm(String jebzbm) {
		this.jebzbm = jebzbm;
	}
	public String getMwskz() {
		return mwskz;
	}
	public void setMwskz(String mwskz) {
		this.mwskz = mwskz;
	}
	public String getKjxybh() {
		return kjxybh;
	}
	public void setKjxybh(String kjxybh) {
		this.kjxybh = kjxybh;
	}
	public String getJyl() {
		return jyl;
	}
	public void setJyl(String jyl) {
		this.jyl = jyl;
	}
	public String getJhrq() {
		return jhrq;
	}
	public void setJhrq(String jhrq) {
		this.jhrq = jhrq;
	}
	public String getPhsb() {
		return phsb;
	}
	public void setPhsb(String phsb) {
		this.phsb = phsb;
	}
	public String getWzwh() {
		return wzwh;
	}
	public void setWzwh(String wzwh) {
		this.wzwh = wzwh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public String getDysm() {
		return dysm;
	}
	public void setDysm(String dysm) {
		this.dysm = dysm;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getSjsl() {
		return sjsl;
	}
	public void setSjsl(String sjsl) {
		this.sjsl = sjsl;
	}
	public String getZldw() {
		return zldw;
	}
	public void setZldw(String zldw) {
		this.zldw = zldw;
	}
	public String getRliid() {
		return rliid;
	}
	public void setRliid(String rliid) {
		this.rliid = rliid;
	}
	public String getZz() {
		return zz;
	}
	public void setZz(String zz) {
		this.zz = zz;
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
	public String getQgdbm() {
		return qgdbm;
	}
	public void setQgdbm(String qgdbm) {
		this.qgdbm = qgdbm;
	}
	public String getQgdxh() {
		return qgdxh;
	}
	public void setQgdxh(String qgdxh) {
		this.qgdxh = qgdxh;
	}
	public String getPpmsqgd() {
		return ppmsqgd;
	}
	public void setPpmsqgd(String ppmsqgd) {
		this.ppmsqgd = ppmsqgd;
	}
	public String getPpmsxh() {
		return ppmsxh;
	}
	public void setPpmsxh(String ppmsxh) {
		this.ppmsxh = ppmsxh;
	}
	public String getQgdms() {
		return qgdms;
	}
	public void setQgdms(String qgdms) {
		this.qgdms = qgdms;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getHeadId() {
		return headId;
	}
	public void setHeadId(Long headId) {
		this.headId = headId;
	}

}
