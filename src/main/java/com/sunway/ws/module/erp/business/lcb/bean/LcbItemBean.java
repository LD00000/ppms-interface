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
    "qgdbm",
    "seqno",
    "pmsno",
    "pmsms",
    "jhkgrq",
    "jhwgrq",
    "sjkgrq",
    "sjwgrq",
    "zzbfb",
    "remark",
    "zmmyl001",
    "zmmyl002",
    "zmmyl003",
    "zmmyl004",
    "zmmyl005",
    "zmmyl006",
    "zmmyl007",
    "zmmyl008",
    "zmmyl009",
    "zmmyl010"
})
public class LcbItemBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -2614515302404541573L;

	@XmlElement(name = "QGDBM")
    protected String qgdbm;
    @XmlElement(name = "SEQNO")
    protected String seqno;
    @XmlElement(name = "PMSNO")
    protected String pmsno;
    @XmlElement(name = "PMSMS")
    protected String pmsms;
    @XmlElement(name = "JHKGRQ")
    protected String jhkgrq;
    @XmlElement(name = "JHWGRQ")
    protected String jhwgrq;
    @XmlElement(name = "SJKGRQ")
    protected String sjkgrq;
    @XmlElement(name = "SJWGRQ")
    protected String sjwgrq;
    @XmlElement(name = "ZZBFB")
    protected String zzbfb;
    @XmlElement(name = "REMARK")
    protected String remark;
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
    @XmlElement(name = "ZMMYL006")
    protected String zmmyl006;
    @XmlElement(name = "ZMMYL007")
    protected String zmmyl007;
    @XmlElement(name = "ZMMYL008")
    protected String zmmyl008;
    @XmlElement(name = "ZMMYL009")
    protected String zmmyl009;
    @XmlElement(name = "ZMMYL010")
    protected String zmmyl010;
    
	public String getQgdbm() {
		return qgdbm;
	}
	public void setQgdbm(String qgdbm) {
		this.qgdbm = qgdbm;
	}
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getPmsno() {
		return pmsno;
	}
	public void setPmsno(String pmsno) {
		this.pmsno = pmsno;
	}
	public String getPmsms() {
		return pmsms;
	}
	public void setPmsms(String pmsms) {
		this.pmsms = pmsms;
	}
	public String getJhkgrq() {
		return jhkgrq;
	}
	public void setJhkgrq(String jhkgrq) {
		this.jhkgrq = jhkgrq;
	}
	public String getJhwgrq() {
		return jhwgrq;
	}
	public void setJhwgrq(String jhwgrq) {
		this.jhwgrq = jhwgrq;
	}
	public String getSjkgrq() {
		return sjkgrq;
	}
	public void setSjkgrq(String sjkgrq) {
		this.sjkgrq = sjkgrq;
	}
	public String getSjwgrq() {
		return sjwgrq;
	}
	public void setSjwgrq(String sjwgrq) {
		this.sjwgrq = sjwgrq;
	}
	public String getZzbfb() {
		return zzbfb;
	}
	public void setZzbfb(String zzbfb) {
		this.zzbfb = zzbfb;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getZmmyl006() {
		return zmmyl006;
	}
	public void setZmmyl006(String zmmyl006) {
		this.zmmyl006 = zmmyl006;
	}
	public String getZmmyl007() {
		return zmmyl007;
	}
	public void setZmmyl007(String zmmyl007) {
		this.zmmyl007 = zmmyl007;
	}
	public String getZmmyl008() {
		return zmmyl008;
	}
	public void setZmmyl008(String zmmyl008) {
		this.zmmyl008 = zmmyl008;
	}
	public String getZmmyl009() {
		return zmmyl009;
	}
	public void setZmmyl009(String zmmyl009) {
		this.zmmyl009 = zmmyl009;
	}
	public String getZmmyl010() {
		return zmmyl010;
	}
	public void setZmmyl010(String zmmyl010) {
		this.zmmyl010 = zmmyl010;
	}

}
