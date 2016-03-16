package com.sunway.ws.module.erp.business.kjxy.bean;

import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ERP2PPMS_KJXY_FEEDBACK", propOrder = {"msgHead", "kjxyLoghs", "kjxyLogls"})
public class KjxyFdServiceBean extends BaseBean {

	@XmlTransient
	@Transient
	private static final long serialVersionUID = -4228391403404838320L;

	@XmlElement(name="ES_MSG_HEAD")
	private MsgHead msgHead;
	@XmlElement(name="ET_ZMMKJXYLOGH")
	private List<KjxyLogh> kjxyLoghs;
	@XmlElement(name="ET_ZMMKJXYLOGL")
	private List<KjxyLogl> kjxyLogls;
	
	public MsgHead getMsgHead() {
		return msgHead;
	}
	public void setMsgHead(MsgHead msgHead) {
		this.msgHead = msgHead;
	}
	public List<KjxyLogh> getKjxyLoghs() {
		return kjxyLoghs;
	}
	public void setKjxyLoghs(List<KjxyLogh> kjxyLoghs) {
		this.kjxyLoghs = kjxyLoghs;
	}
	public List<KjxyLogl> getKjxyLogls() {
		return kjxyLogls;
	}
	public void setKjxyLogls(List<KjxyLogl> kjxyLogls) {
		this.kjxyLogls = kjxyLogls;
	}
	
}
