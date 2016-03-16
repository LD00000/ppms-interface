package com.sunway.ws.module.erp.business.ckd.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;

@Table(name="i_erp_ckd")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zlineid",
    "ckdh",
    "ckdbc",
    "msgid",
    "logsys",
    "ckddms",
    "ckdms",
    "xmbm",
    "zybm",
    "htbm",
    "gfdwbm",
    "fhdh",
    "fhrm",
    "fhrq",
    "fph",
    "zrcgrbm",
    "zrcgrmc",
    "zdr",
    "zdrm",
    "zdrq",
    "zdsm",
    "swr",
    "swrm",
    "swrq",
    "swbz",
    "tkbz",
    "bukrs",
    "posteddate",
    "marainrkdid",
    "ztmc",
    "htbc",
    "kfmc",
    "zbukrs",
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
public class CkdBean extends BaseBean {

	@Transient
	private static final long serialVersionUID = -5646429143625898283L;
	
	@Id
	@XmlTransient
	private Long id;
	@XmlElement(name = "ZLINEID")
    protected String zlineid;
    @XmlElement(name = "RKDH")
    protected String ckdh;
    @XmlElement(name = "RKDBC")
    protected String ckdbc;
    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "LOGSYS")
    protected String logsys;
    @XmlElement(name = "RKDDMS")
    protected String ckddms;
    @XmlElement(name = "RKDMS")
    protected String ckdms;
    @XmlElement(name = "XMBM")
    protected String xmbm;
    @XmlElement(name = "ZYBM")
    protected String zybm;
    @XmlElement(name = "HTBM")
    protected String htbm;
    @XmlElement(name = "GFDWBM")
    protected String gfdwbm;
    @XmlElement(name = "FHDH")
    protected String fhdh;
    @XmlElement(name = "FHRM")
    protected String fhrm;
    @XmlElement(name = "FHRQ")
    protected String fhrq;
    @XmlElement(name = "FPH")
    protected String fph;
    @XmlElement(name = "ZRCGRBM")
    protected String zrcgrbm;
    @XmlElement(name = "ZRCGRMC")
    protected String zrcgrmc;
    @XmlElement(name = "ZDR")
    protected String zdr;
    @XmlElement(name = "ZDRM")
    protected String zdrm;
    @XmlElement(name = "ZDRQ")
    protected String zdrq;
    @XmlElement(name = "ZDSM")
    protected String zdsm;
    @XmlElement(name = "SWR")
    protected String swr;
    @XmlElement(name = "SWRM")
    protected String swrm;
    @XmlElement(name = "SWRQ")
    protected String swrq;
    @XmlElement(name = "SWBZ")
    protected String swbz;
    @XmlElement(name = "TKBZ")
    protected String tkbz;
    @XmlElement(name = "BUKRS")
    protected String bukrs;
    @XmlElement(name = "POSTEDDATE")
    protected String posteddate;
    @XmlElement(name = "MARAINRKDID")
    protected String marainrkdid;
    @XmlElement(name = "ZTMC")
    protected String ztmc;
    @XmlElement(name = "HTBC")
    protected String htbc;
    @XmlElement(name = "KFMC")
    protected String kfmc;
    @XmlElement(name = "ZBUKRS")
    private String zbukrs;
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
    @XmlTransient
    private String status;
    
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
	public String getXmbm() {
		return xmbm;
	}
	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}
	public String getZybm() {
		return zybm;
	}
	public void setZybm(String zybm) {
		this.zybm = zybm;
	}
	public String getHtbm() {
		return htbm;
	}
	public void setHtbm(String htbm) {
		this.htbm = htbm;
	}
	public String getGfdwbm() {
		return gfdwbm;
	}
	public void setGfdwbm(String gfdwbm) {
		this.gfdwbm = gfdwbm;
	}
	public String getFhdh() {
		return fhdh;
	}
	public void setFhdh(String fhdh) {
		this.fhdh = fhdh;
	}
	public String getFhrm() {
		return fhrm;
	}
	public void setFhrm(String fhrm) {
		this.fhrm = fhrm;
	}
	public String getFhrq() {
		return fhrq;
	}
	public void setFhrq(String fhrq) {
		this.fhrq = fhrq;
	}
	public String getFph() {
		return fph;
	}
	public void setFph(String fph) {
		this.fph = fph;
	}
	public String getZrcgrbm() {
		return zrcgrbm;
	}
	public void setZrcgrbm(String zrcgrbm) {
		this.zrcgrbm = zrcgrbm;
	}
	public String getZrcgrmc() {
		return zrcgrmc;
	}
	public void setZrcgrmc(String zrcgrmc) {
		this.zrcgrmc = zrcgrmc;
	}
	public String getZdr() {
		return zdr;
	}
	public void setZdr(String zdr) {
		this.zdr = zdr;
	}
	public String getZdrm() {
		return zdrm;
	}
	public void setZdrm(String zdrm) {
		this.zdrm = zdrm;
	}
	public String getZdrq() {
		return zdrq;
	}
	public void setZdrq(String zdrq) {
		this.zdrq = zdrq;
	}
	public String getZdsm() {
		return zdsm;
	}
	public void setZdsm(String zdsm) {
		this.zdsm = zdsm;
	}
	public String getSwr() {
		return swr;
	}
	public void setSwr(String swr) {
		this.swr = swr;
	}
	public String getSwrm() {
		return swrm;
	}
	public void setSwrm(String swrm) {
		this.swrm = swrm;
	}
	public String getSwrq() {
		return swrq;
	}
	public void setSwrq(String swrq) {
		this.swrq = swrq;
	}
	public String getSwbz() {
		return swbz;
	}
	public void setSwbz(String swbz) {
		this.swbz = swbz;
	}
	public String getTkbz() {
		return tkbz;
	}
	public void setTkbz(String tkbz) {
		this.tkbz = tkbz;
	}
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	public String getMarainrkdid() {
		return marainrkdid;
	}
	public void setMarainrkdid(String marainrkdid) {
		this.marainrkdid = marainrkdid;
	}
	public String getZtmc() {
		return ztmc;
	}
	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
	public String getHtbc() {
		return htbc;
	}
	public void setHtbc(String htbc) {
		this.htbc = htbc;
	}
	public String getKfmc() {
		return kfmc;
	}
	public void setKfmc(String kfmc) {
		this.kfmc = kfmc;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getCkddms() {
		return ckddms;
	}
	public void setCkddms(String ckddms) {
		this.ckddms = ckddms;
	}
	public String getCkdms() {
		return ckdms;
	}
	public void setCkdms(String ckdms) {
		this.ckdms = ckdms;
	}
	public String getZbukrs() {
		return zbukrs;
	}
	public void setZbukrs(String zbukrs) {
		this.zbukrs = zbukrs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
