
package com.sunway.ws.module.erp.business.ckd.bean;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.module.erp.common.bean.MsgHead;


/**
 * PPMS��ERP���ϳ������
 * 
 * <p>DT_SEG_PPMS_CA_GI_REQ_OUT complex type�� Java �ࡣ
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DT_SEG_PPMS_CA_GI_REQ_OUT", propOrder = {
    "ismsghead",
    "isheader",
    "ititems"
})
public class CkdServiceBean extends BaseBean {

	private static final long serialVersionUID = -7609495000920541141L;

	@XmlElement(name = "IS_MSG_HEAD")
    protected MsgHead ismsghead;
    @XmlElement(name = "IS_HEADER")
    protected CkdBean isheader;
    @XmlElement(name = "IT_ITEMS")
    protected List<CkdItemBean> ititems;
    
	public MsgHead getIsmsghead() {
		return ismsghead;
	}
	public void setIsmsghead(MsgHead ismsghead) {
		this.ismsghead = ismsghead;
	}
	public CkdBean getIsheader() {
		return isheader;
	}
	public void setIsheader(CkdBean isheader) {
		this.isheader = isheader;
	}
	public List<CkdItemBean> getItitems() {
		return ititems;
	}
	public void setItitems(List<CkdItemBean> ititems) {
		this.ititems = ititems;
	}

}
