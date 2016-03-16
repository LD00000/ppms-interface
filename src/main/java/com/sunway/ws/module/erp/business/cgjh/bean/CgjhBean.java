package com.sunway.ws.module.erp.business.cgjh.bean;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

@Table(name = "i_erp_cgjh")
@XmlAccessorType(XmlAccessType.FIELD)
@WebService  
@SOAPBinding(style = Style.RPC)
public class CgjhBean extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = 4272045172597183175L;

	@Id
	@XmlTransient
	private Long id;
	@XmlElement(name = "ZLINEID")
	private String zlineid;	// 
	@XmlElement(name = "ZCGJH")
	private String zcgjh;	// �ɹ��ƻ���
	@XmlElement(name = "STATS")
	private String stats;	// 
	@XmlElement(name = "BUKRS")
	private String bukrs;	// ��˾����
	@XmlElement(name = "WERKS")
	private String werks;	// ����
	@XmlElement(name = "ZCGJHMC")
	private String zcgjhmc;	// �ɹ��ƻ�����
	@XmlElement(name = "PSPID")
	private String pspid;	// ��Ŀ����
	@XmlElement(name = "POST1")
	private String post1;
	@XmlElement(name = "EKGRP")
	private String ekgrp;
	@XmlElement(name = "ZXMBM")
	private String zxmbm;	// PPMS��Ŀ����
	@XmlElement(name = "ZXMMC")
	private String zxmmc;	// PPMS��Ŀ����
	@XmlElement(name = "SPRAS")
	private String spras;	// ����
	@XmlElement(name = "ERNAM")
	private String ernam;	// �����������Ա����
	@XmlElement(name = "ERDAT")
	private String erdat;		// ��¼�Ĵ�������
	
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
	public String getStats() {
		return stats;
	}
	public void setStats(String stats) {
		this.stats = stats;
	}
	public String getBukrs() {
		return bukrs;
	}
	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getZcgjhmc() {
		return zcgjhmc;
	}
	public void setZcgjhmc(String zcgjhmc) {
		this.zcgjhmc = zcgjhmc;
	}
	public String getPspid() {
		return pspid;
	}
	public void setPspid(String pspid) {
		this.pspid = pspid;
	}
	public String getZxmbm() {
		return zxmbm;
	}
	public void setZxmbm(String zxmbm) {
		this.zxmbm = zxmbm;
	}
	public String getZxmmc() {
		return zxmmc;
	}
	public void setZxmmc(String zxmmc) {
		this.zxmmc = zxmmc;
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
	public String getPost1() {
		return post1;
	}
	public void setPost1(String post1) {
		this.post1 = post1;
	}
	public String getEkgrp() {
		return ekgrp;
	}
	public void setEkgrp(String ekgrp) {
		this.ekgrp = ekgrp;
	}
	public String getSpras() {
		return spras;
	}
	public void setSpras(String spras) {
		this.spras = spras;
	}
}
