package com.sunway.ws.module.erp.business.lcb.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_LCB_REQ", propOrder = {
    "ismsghead",
    "isdochead",
    "itdocitem"
})
public class LcbServiceBean {
	
	@XmlElement(name = "IS_MSG_HEAD")
    protected MsgHead ismsghead;
	@XmlElement(name = "IS_DOC_HEAD")
    protected LcbBean isdochead;
    @XmlElement(name = "IT_DOC_ITEM")
    protected List<LcbItemBean> itdocitem;
    
	public MsgHead getIsmsghead() {
		return ismsghead;
	}
	public void setIsmsghead(MsgHead ismsghead) {
		this.ismsghead = ismsghead;
	}
	public LcbBean getIsdochead() {
		return isdochead;
	}
	public void setIsdochead(LcbBean isdochead) {
		this.isdochead = isdochead;
	}
	public List<LcbItemBean> getItdocitem() {
		return itdocitem;
	}
	public void setItdocitem(List<LcbItemBean> itdocitem) {
		this.itdocitem = itdocitem;
	}

}
