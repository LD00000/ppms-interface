package com.sunway.ws.module.erp.business.cght.bean;

import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.business.feedback.bean.Message;
import com.sunway.ws.module.erp.common.bean.MsgHead;

/**
 * 反馈
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERP2PPMS_CGHT_FEEDBACK", propOrder = {"msgHead", "messages", "cghtLogs"})
public class CghtFdServerBean extends BaseBean {

	@Transient
	@XmlTransient
	private static final long serialVersionUID = 4180700192534259191L;

	private MsgHead msgHead;
	private List<Message> messages;
	private List<CghtLog> cghtLogs;
	
	public MsgHead getMsgHead() {
		return msgHead;
	}
	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<CghtLog> getCghtLogs() {
		return cghtLogs;
	}
	public void setCghtLogs(List<CghtLog> cghtLogs) {
		this.cghtLogs = cghtLogs;
	}
	
}
