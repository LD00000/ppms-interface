package com.sunway.ws.module.erp.business.rkd.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.business.feedback.bean.Message;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERP2PPMS_RKD_FEEDBACK", propOrder = {"msgHead", "messages", "rkdLogs"})
public class RkdFdServerBean extends BaseBean {

	private static final long serialVersionUID = -4228391403404838320L;

	private MsgHead msgHead;
	private List<Message> messages;
	private List<RkdLog> rkdLogs;
	
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
	public List<RkdLog> getRkdLogs() {
		return rkdLogs;
	}
	public void setRkdLogs(List<RkdLog> rkdLogs) {
		this.rkdLogs = rkdLogs;
	}
	
}
