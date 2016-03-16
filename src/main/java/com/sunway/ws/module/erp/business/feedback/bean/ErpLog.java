package com.sunway.ws.module.erp.business.feedback.bean;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sunway.ws.core.bean.BaseBean;

/**
 * erp 接口日志
 */
@Table(name="i_erp_log")
public class ErpLog extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = 3775800310919818689L;
	
	@Id
	private long id;
	private String interfaceName;
	private String msgid;
	private String log;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}

}
