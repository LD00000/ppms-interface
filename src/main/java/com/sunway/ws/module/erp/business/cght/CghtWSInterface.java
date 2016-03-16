package com.sunway.ws.module.erp.business.cght;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;

/**
 * ����ӿڣ����ڿͻ������ɷ���
 * 
 * @author lidong
 *
 */
@WebService(targetNamespace = "urn:seg:ecc:ca:ppms", name = "SI_SEG_PPMS_CA_PO_CRT_REQ_A_OUT")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CghtWSInterface {
	
	@Oneway
    @WebMethod(operationName = "SI_SEG_PPMS_CA_PO_CRT_REQ_A_OUT", action = "http://sap.com/xi/WebService/soap1.1")
    public void siSEGPPMSCAPOCRTREQAOUT(
        @WebParam(partName = "MT_SEG_PPMS_CA_PO_CRT_REQ_OUT", name = "MT_SEG_PPMS_CA_PO_CRT_REQ_OUT", targetNamespace = "urn:seg:ecc:ca:ppms")
        CghtServiceBean cghtServiceBean
    );

}
