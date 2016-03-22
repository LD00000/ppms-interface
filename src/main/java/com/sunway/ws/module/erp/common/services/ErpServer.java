package com.sunway.ws.module.erp.common.services;

import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentation.Placement;

import com.sunway.ws.module.erp.business.cght.bean.CghtFdServerBean;
import com.sunway.ws.module.erp.business.cgjh.bean.CgjhServiceBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdFdServerBean;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyFdServiceBean;
import com.sunway.ws.module.erp.business.lcb.bean.LcbFdServiceBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdFdServerBean;

import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WebService(serviceName = "erpServer", targetNamespace="http://services.common.erp.webservice.sunwayworld.com/")
@WSDLDocumentationCollection({
	@WSDLDocumentation(value = "ERP2PPMS接口", placement = Placement.TOP),
	@WSDLDocumentation(value = "ERP2PPMS接口", placement = Placement.SERVICE)
})
public interface ErpServer {

	@WSDLDocumentation("ERP推送采购计划")
	public void insertCgjh(CgjhServiceBean cgjh);
	@WSDLDocumentation("ERP推送采购合同反馈结果")
	public void insertCghtFeedback(CghtFdServerBean cghtFd);
	@WSDLDocumentation("ERP推送入库反馈结果")
	public void insertRkdFeedback(RkdFdServerBean rkdFd);
	@WSDLDocumentation("ERP推送出库反馈结果")
	public void insertCkdFeedback(CkdFdServerBean ckdFd);
	@WSDLDocumentation("ERP推送里程碑反馈结果")
	public void insertLcbFeedback(LcbFdServiceBean lcbFd);
	@WSDLDocumentation("ERP推送框架协议反馈结果")
	public void insertKjxyFeedback(KjxyFdServiceBean kjxyFd);
	
}
