
package com.sunway.ws.module.erp.business.rkd.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.module.erp.common.bean.MsgHead;


/**
 * PPMS��ERP�ɹ��ջ�����
 * 
 * <p>DT_SEG_PPMS_CA_GR_REQ_OUT complex type�� Java �ࡣ
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_GR_REQ_OUT", propOrder = {
    "ismsghead",
    "isheader",
    "ititems"
})
public class RkdServiceBean {

    @XmlElement(name = "IS_MSG_HEAD")
    protected MsgHead ismsghead;
    @XmlElement(name = "IS_HEADER")
    protected RkdBean isheader;
    @XmlElement(name = "IT_ITEMS")
    protected List<RkdItemBean> ititems;
    
	public MsgHead getIsmsghead() {
		return ismsghead;
	}
	public void setIsmsghead(MsgHead ismsghead) {
		this.ismsghead = ismsghead;
	}
	public RkdBean getIsheader() {
		return isheader;
	}
	public void setIsheader(RkdBean isheader) {
		this.isheader = isheader;
	}
	public List<RkdItemBean> getItitems() {
		return ititems;
	}
	public void setItitems(List<RkdItemBean> ititems) {
		this.ititems = ititems;
	}

}
