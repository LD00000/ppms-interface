package com.sunway.ws.module.erp.business.feedback.bean;

import java.util.List;

import javax.persistence.Transient;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.common.bean.MsgHead;

/**
 * erp �������������
 * 
 * @param <T> log ����
 * 
 * @author lidong
 */
public abstract class BaseFdMsgBean<T extends BaseLog> extends BaseBean {

	@Transient
	private static final long serialVersionUID = -8354828753026872158L;

	private MsgHead msgHead;
	private List<Message> messagess;
	protected List<T> logs;

	public MsgHead getMsgHead() {
		return msgHead;
	}

	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}

	public List<Message> getMessagess() {
		return messagess;
	}

	public void setMessagess(List<Message> messagess) {
		this.messagess = messagess;
	}

	public abstract List<T> getLogs();

	public abstract void setLogs(List<T> logs);

}
