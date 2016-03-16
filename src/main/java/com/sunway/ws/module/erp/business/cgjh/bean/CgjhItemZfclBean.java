package com.sunway.ws.module.erp.business.cgjh.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;

@Table(name="i_erp_cgjh_item_zfcl")
@XmlAccessorType(XmlAccessType.FIELD)
public class CgjhItemZfclBean extends BaseBean {
	
	@Transient
	@XmlTransient
	private static final long serialVersionUID = 8609448656362479725L;
	
	@Id
	@XmlTransient
	@Transient
	private Long id;
	@XmlElement(name = "ZLINEID")
	private String zlineid;
	@XmlElement(name = "ZCGJH")
	private String zcgjh;
	@XmlElement(name = "ZCGXH")
	private String zcgxh;
	@XmlElement(name = "ZJHXH")
	private String zjhxh;
	@XmlElement(name = "SEQNO")
	private String seqno;
	@XmlElement(name = "ZZFCL")
	private String zzfcl;
	@XmlElement(name = "ZZBFB")
	private String zzbfb;
	@XmlElement(name = "ZMMYL01")
	private String zmmyl01;
	@XmlElement(name = "ZMMYL02")
	private String zmmyl02;
	@XmlElement(name = "ZMMYL03")
	private String zmmyl03;
	@XmlElement(name = "ZMMYL04")
	private String zmmyl04;
	@XmlElement(name = "ZMMYL05")
	private String zmmyl05;
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
	public String getSeqno() {
		return seqno;
	}
	public void setSeqno(String seqno) {
		this.seqno = seqno;
	}
	public String getZzfcl() {
		return zzfcl;
	}
	public void setZzfcl(String zzfcl) {
		this.zzfcl = zzfcl;
	}
	public String getZzbfb() {
		return zzbfb;
	}
	public void setZzbfb(String zzbfb) {
		this.zzbfb = zzbfb;
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
	public String getZcgxh() {
		return zcgxh;
	}
	public void setZcgxh(String zcgxh) {
		this.zcgxh = zcgxh;
	}
	public Long getHeadId() {
		return headId;
	}
	public void setHeadId(Long headId) {
		this.headId = headId;
	}

	
}
