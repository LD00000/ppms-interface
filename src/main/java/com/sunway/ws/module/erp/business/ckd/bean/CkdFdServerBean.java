package com.sunway.ws.module.erp.business.ckd.bean;

import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.business.feedback.bean.Message;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERP2PPMS_CKD_FEEDBACK", propOrder = {"msgHead", "messages", "ckdLogs"})
public class CkdFdServerBean extends BaseBean {

	@Transient
	private static final long serialVersionUID = -6870321479143595177L;
	
	private MsgHead msgHead;
	private List<Message> messages;
	private List<CkdLog> ckdLogs;
	
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
	public List<CkdLog> getCkdLogs() {
		return ckdLogs;
	}
	public void setCkdLogs(List<CkdLog> ckdLogs) {
		this.ckdLogs = ckdLogs;
	}
	
}
