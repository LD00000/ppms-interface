package com.sunway.ws.module.erp.business.cgjh.bean;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"msgHead", "cgjh", "cgjhItems", "cgjhItemZfcls", "cgjhItemGyss", "cgjhItemKjxys", "cgjhItemLcbs"})
@WebService  
@SOAPBinding(style = Style.RPC)  
public class CgjhServiceBean extends BaseBean {
	
	@XmlTransient
	@Transient
	private static final long serialVersionUID = -547414728312445198L;
	
	@XmlElement(name = "IS_MSG_HEAD")
	private MsgHead msgHead;				// ��Ϣͷ
	@XmlElement(name = "IS_HEADER")
	private CgjhBean cgjh;			// �ɹ��ƻ�
	@XmlElement(name = "IT_ITEMS")
	private List<CgjhItemBean> cgjhItems;	// �ɹ��ƻ���ϸ
	@XmlElement(name = "IT_ITEMS_ZFCL")
	private List<CgjhItemZfclBean> cgjhItemZfcls;
	@XmlElement(name = "IT_ITEMS_GYS")
	private List<CgjhItemGysBean> cgjhItemGyss;
	@XmlElement(name = "IT_ITEMS_KJXY")
	private List<CgjhItemKjxyBean> cgjhItemKjxys;
	@XmlElement(name = "IT_ITEMS_LCB")
	private List<CgjhItemLcbBean> cgjhItemLcbs;
	
	public MsgHead getMsgHead() {
		return msgHead;
	}
	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}
	public List<CgjhItemBean> getCgjhItems() {
		return cgjhItems;
	}
	public void setCgjhItems(List<CgjhItemBean> cgjhItems) {
		this.cgjhItems = cgjhItems;
	}
	public List<CgjhItemZfclBean> getCgjhItemZfcls() {
		return cgjhItemZfcls;
	}
	public void setCgjhItemZfcls(List<CgjhItemZfclBean> cgjhItemZfcls) {
		this.cgjhItemZfcls = cgjhItemZfcls;
	}
	public List<CgjhItemGysBean> getCgjhItemGyss() {
		return cgjhItemGyss;
	}
	public void setCgjhItemGyss(List<CgjhItemGysBean> cgjhItemGyss) {
		this.cgjhItemGyss = cgjhItemGyss;
	}
	public List<CgjhItemKjxyBean> getCgjhItemKjxys() {
		return cgjhItemKjxys;
	}
	public void setCgjhItemKjxys(List<CgjhItemKjxyBean> cgjhItemKjxys) {
		this.cgjhItemKjxys = cgjhItemKjxys;
	}
	public List<CgjhItemLcbBean> getCgjhItemLcbs() {
		return cgjhItemLcbs;
	}
	public void setCgjhItemLcbs(List<CgjhItemLcbBean> cgjhItemLcbs) {
		this.cgjhItemLcbs = cgjhItemLcbs;
	}
	public CgjhBean getCgjh() {
		return cgjh;
	}
	public void setCgjh(CgjhBean cgjh) {
		this.cgjh = cgjh;
	}
	
}
