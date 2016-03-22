package com.sunway.ws.module.erp.business.cgjh.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_PR_RESP", propOrder = {
    "esmsghead",
    "etmessage"
})
public class CgjhFdServiceBean {

	@XmlElement(name = "ES_MSG_HEAD")
    protected MsgHead esmsghead;
    @XmlElement(name = "ET_MESSAGE")
    protected List<CgjhMessage> etmessage;
    
	public MsgHead getEsmsghead() {
		return esmsghead;
	}
	public void setEsmsghead(MsgHead esmsghead) {
		this.esmsghead = esmsghead;
	}
	public List<CgjhMessage> getEtmessage() {
		return etmessage;
	}
	public void setEtmessage(List<CgjhMessage> etmessage) {
		this.etmessage = etmessage;
	}
	
}
