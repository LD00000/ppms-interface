
package com.sunway.ws.module.erp.business.cght.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.module.erp.common.bean.MsgHead;

/**
 * 发送订单到 ERP bean
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_PO_CRT_REQ_OUT", propOrder = {
    "ismsghead",
    "isheader",
    "ititems",
    "itpay",
    "cghtQtfy"
})
public class CghtServiceBean {

    @XmlElement(name = "IS_MSG_HEAD")
    protected MsgHead ismsghead;
    @XmlElement(name = "IS_HEADER")
    protected CghtBean isheader;
    @XmlElement(name = "IT_ITEMS")
    protected List<CghtItemBean> ititems;
    @XmlElement(name = "IS_HEADER_PAY")
    protected List<CghtPayBean> itpay;
    @XmlElement(name = "IS_HEADER_COND")
    protected List<CghtQtfyBean> cghtQtfy;
    
	public MsgHead getIsmsghead() {
		return ismsghead;
	}
	public void setIsmsghead(MsgHead ismsghead) {
		this.ismsghead = ismsghead;
	}
	public CghtBean getIsheader() {
		return isheader;
	}
	public void setIsheader(CghtBean isheader) {
		this.isheader = isheader;
	}
	public List<CghtItemBean> getItitems() {
		return ititems;
	}
	public void setItitems(List<CghtItemBean> ititems) {
		this.ititems = ititems;
	}
	public List<CghtPayBean> getItpay() {
		return itpay;
	}
	public void setItpay(List<CghtPayBean> itpay) {
		this.itpay = itpay;
	}
	public List<CghtQtfyBean> getCghtQtfy() {
		return cghtQtfy;
	}
	public void setCghtQtfy(List<CghtQtfyBean> cghtQtfy) {
		this.cghtQtfy = cghtQtfy;
	}

}
