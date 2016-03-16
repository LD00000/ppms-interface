package com.sunway.ws.module.erp.business.kjxy.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.module.erp.common.bean.MsgHead;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_KJXY_REQ", propOrder = {
    "ismsghead",
    "isekohead",
    "itekoitem"
})
public class KjxyServiceBean {
	
	@XmlElement(name = "IS_MSG_HEAD")
    protected MsgHead ismsghead;
    @XmlElement(name = "IS_EKO_HEAD")
    protected KjxyBean isekohead;
    @XmlElement(name = "IT_EKO_ITEM")
    protected List<KjxyItemBean> itekoitem;
    
	public MsgHead getIsmsghead() {
		return ismsghead;
	}
	public void setIsmsghead(MsgHead ismsghead) {
		this.ismsghead = ismsghead;
	}
	public KjxyBean getIsekohead() {
		return isekohead;
	}
	public void setIsekohead(KjxyBean isekohead) {
		this.isekohead = isekohead;
	}
	public List<KjxyItemBean> getItekoitem() {
		return itekoitem;
	}
	public void setItekoitem(List<KjxyItemBean> itekoitem) {
		this.itekoitem = itekoitem;
	}

}
