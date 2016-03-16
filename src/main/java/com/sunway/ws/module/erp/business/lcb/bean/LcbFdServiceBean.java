package com.sunway.ws.module.erp.business.lcb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERP2PPMS_LCB_FEEDBACK", propOrder = {"msgHead", "lcbLogs"})
public class LcbFdServiceBean extends BaseBean {

	@XmlTransient
	private static final long serialVersionUID = -4228391403404838320L;

	private MsgHead msgHead;
	private List<LcbLog> lcbLogs;
	
	public MsgHead getMsgHead() {
		return msgHead;
	}
	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}
	public List<LcbLog> getLcbLogs() {
		return lcbLogs;
	}
	public void setLcbLogs(List<LcbLog> lcbLogs) {
		this.lcbLogs = lcbLogs;
	}
	
}
