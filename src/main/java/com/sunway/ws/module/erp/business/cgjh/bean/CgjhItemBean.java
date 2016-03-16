package com.sunway.ws.module.erp.business.cgjh.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

@Table(name="i_erp_cgjh_item")
@XmlAccessorType(XmlAccessType.FIELD)
public class CgjhItemBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = -4042285087150288564L;

	@Id
	@Transient
	@XmlTransient
	private Long id;
	@XmlElement(name = "ZLINEID")
	private String zlineid;	// �к�
	@XmlElement(name = "ZCGJH")
	private String zcgjh;	// �ɹ��ƻ���
	@XmlElement(name = "ZCGXH")
	private String zcgxh;
	@XmlElement(name = "ZJHXH")
	private String zjhxh;	// ���
	@XmlElement(name = "STUFE")
	private String stufe;	// ��Ŀ��εĵȼ�
	@XmlElement(name = "WBS")
	private String wbs;		// �����ֽ�ṹԪ�� (WBS Ԫ��)
	@XmlElement(name = "POST1")
	private String post1;	
	@XmlElement(name = "MATKL")
	private String matkl;
	@XmlElement(name = "ZNDCL")
	private String zndcl;
	@XmlElement(name = "POSNR")
	private String posnr;
	@XmlElement(name = "LGORT")
	private String lgort;	// ���ص�
	@XmlElement(name = "TIDNR")
	private String tidnr;	// װ�ú�
	@XmlElement(name = "ZCGMS")
	private String zcgms;	// 
	@XmlElement(name = "ZCGFS")
	private String zcgfs;	// �ɹ���ʽ
	@XmlElement(name = "REMARK")
	private String remark;	// ��
	@XmlElement(name = "ZJGKZFS")
	private String zjgkzfs;
	@XmlElement(name = "QGDRQ")
	private String qgdrq;
	@XmlElement(name = "BEDAT")
	private String bedat;
	@XmlElement(name = "BRTWR")
	private String brtwr;
	@XmlElement(name = "WAERS")
	private String waers;
	@XmlElement(name = "DMBTR")
	private String dmbtr;
	@XmlElement(name = "KTMNG")
	private String ktmng;
	@XmlElement(name = "MEINS")
	private String meins;
	@XmlElement(name = "ZLKZDJ")
	private String zlkzdj;
	@XmlElement(name = "ZLKZCS")
	private String zlkzcs;
	@XmlElement(name = "ZJDKZDJ")
	private String zjdkzdj;
	@XmlElement(name = "ZJDKZCS")
	private String zjdkzcs;
	@XmlElement(name = "ZYSDJ")
	private String zysdj;
	@XmlElement(name = "ZYSFS")
	private String zysfs;
	@XmlElement(name = "ZWLLB")
	private String zwllb;
	@XmlTransient
	private Long headId;
	
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
	public String getZcgjh() {
		return zcgjh;
	}
	public void setZcgjh(String zcgjh) {
		this.zcgjh = zcgjh;
	}
	public String getZjhxh() {
		return zjhxh;
	}
	public void setZjhxh(String zjhxh) {
		this.zjhxh = zjhxh;
	}
	public String getStufe() {
		return stufe;
	}
	public void setStufe(String stufe) {
		this.stufe = stufe;
	}
	public String getWbs() {
		return wbs;
	}
	public void setWbs(String wbs) {
		this.wbs = wbs;
	}
	public String getLgort() {
		return lgort;
	}
	public void setLgort(String lgort) {
		this.lgort = lgort;
	}
	public String getTidnr() {
		return tidnr;
	}
	public void setTidnr(String tidnr) {
		this.tidnr = tidnr;
	}
	public String getZcgms() {
		return zcgms;
	}
	public void setZcgms(String zcgms) {
		this.zcgms = zcgms;
	}
	public String getZcgfs() {
		return zcgfs;
	}
	public void setZcgfs(String zcgfs) {
		this.zcgfs = zcgfs;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMatkl() {
		return matkl;
	}
	public void setMatkl(String matkl) {
		this.matkl = matkl;
	}
	public String getZndcl() {
		return zndcl;
	}
	public void setZndcl(String zndcl) {
		this.zndcl = zndcl;
	}
	public String getPosnr() {
		return posnr;
	}
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}
	public String getZjgkzfs() {
		return zjgkzfs;
	}
	public void setZjgkzfs(String zjgkzfs) {
		this.zjgkzfs = zjgkzfs;
	}
	public String getQgdrq() {
		return qgdrq;
	}
	public void setQgdrq(String qgdrq) {
		this.qgdrq = qgdrq;
	}
	public String getBedat() {
		return bedat;
	}
	public void setBedat(String bedat) {
		this.bedat = bedat;
	}
	public String getBrtwr() {
		return brtwr;
	}
	public void setBrtwr(String brtwr) {
		this.brtwr = brtwr;
	}
	public String getWaers() {
		return waers;
	}
	public void setWaers(String waers) {
		this.waers = waers;
	}
	public String getDmbtr() {
		return dmbtr;
	}
	public void setDmbtr(String dmbtr) {
		this.dmbtr = dmbtr;
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
	public String getZlkzdj() {
		return zlkzdj;
	}
	public void setZlkzdj(String zlkzdj) {
		this.zlkzdj = zlkzdj;
	}
	public String getZlkzcs() {
		return zlkzcs;
	}
	public void setZlkzcs(String zlkzcs) {
		this.zlkzcs = zlkzcs;
	}
	public String getZjdkzdj() {
		return zjdkzdj;
	}
	public void setZjdkzdj(String zjdkzdj) {
		this.zjdkzdj = zjdkzdj;
	}
	public String getZjdkzcs() {
		return zjdkzcs;
	}
	public void setZjdkzcs(String zjdkzcs) {
		this.zjdkzcs = zjdkzcs;
	}
	public String getZysdj() {
		return zysdj;
	}
	public void setZysdj(String zysdj) {
		this.zysdj = zysdj;
	}
	public String getZysfs() {
		return zysfs;
	}
	public void setZysfs(String zysfs) {
		this.zysfs = zysfs;
	}
	public String getZwllb() {
		return zwllb;
	}
	public void setZwllb(String zwllb) {
		this.zwllb = zwllb;
	}
	public String getZcgxh() {
		return zcgxh;
	}
	public void setZcgxh(String zcgxh) {
		this.zcgxh = zcgxh;
	}
	public String getPost1() {
		return post1;
	}
	public void setPost1(String post1) {
		this.post1 = post1;
	}
	public Long getHeadId() {
		return headId;
	}
	public void setHeadId(Long headId) {
		this.headId = headId;
	}
	
}
