package com.sunway.ws.module;

import com.sunway.ws.module.erp.business.cght.CghtWSInterface;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhFdServiceBean;
import com.sunway.ws.module.erp.business.ckd.CkdWSInterface;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServiceBean;
import com.sunway.ws.module.erp.business.feedback.CgjhFeedbackWSInterface;
import com.sunway.ws.module.erp.business.kjxy.KjxyWSInterface;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;
import com.sunway.ws.module.erp.business.lcb.LcbWSInterface;
import com.sunway.ws.module.erp.business.lcb.bean.LcbServiceBean;
import com.sunway.ws.module.erp.business.rkd.RkdWSInterface;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServiceBean;

public enum WSInterface {
	
	/** ERP 采购计划反馈接口 **/
	ERP_CGJH_FEEDBACK("ERP_CGJH_FEEDBACK", CgjhFdServiceBean.class, CgjhFeedbackWSInterface.class),
	/** ERP 采购合同接口 **/
	ERP_CGHT("ERP_CGHT", CghtServiceBean.class, CghtWSInterface.class),
	/** ERP 框架协议接口 **/
	ERP_KJXY("ERP_KJXY", KjxyServiceBean.class, KjxyWSInterface.class),
	/** ERP 出库单接口 **/
	ERP_CKD("ERP_CKD", CkdServiceBean.class, CkdWSInterface.class),
	/** ERP 入库单接口 **/
	ERP_RKD("ERP_RKD", RkdServiceBean.class, RkdWSInterface.class),
	/** ERP 里程碑接口 **/
	ERP_LCB("ERP_LCB", LcbServiceBean.class, LcbWSInterface.class);
	
	private String name;
	private Class<?> serviceBeanClazz;
	private Class<?> WSInterfaceClazz;
	
	private WSInterface(String name, Class<?> serviceBeanClazz, Class<?> WSInterfaceClazz) {
		this.name = name;
		this.serviceBeanClazz = serviceBeanClazz;
		this.WSInterfaceClazz = WSInterfaceClazz;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getServiceBeanClazz() {
		return serviceBeanClazz;
	}

	public void setServiceBeanClazz(Class<?> serviceBeanClazz) {
		this.serviceBeanClazz = serviceBeanClazz;
	}

	public Class<?> getWSInterfaceClazz() {
		return WSInterfaceClazz;
	}

	public void setWSInterfaceClazz(Class<?> wSInterfaceClazz) {
		WSInterfaceClazz = wSInterfaceClazz;
	}

}
