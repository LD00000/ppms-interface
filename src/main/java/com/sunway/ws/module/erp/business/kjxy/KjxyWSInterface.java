package com.sunway.ws.module.erp.business.kjxy;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;

/**
 * This class was generated by Apache CXF 3.0.6
 * 2016-01-24T23:28:47.071+08:00
 * Generated source version: 3.0.6
 * 
 */
@WebService(targetNamespace = "urn:seg:ecc:ca:ppms", name = "SI_SEG_PPMS_CA_KJXY_REQ_A_OUT")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface KjxyWSInterface {

    @WebMethod(operationName = "SI_SEG_PPMS_CA_KJXY_REQ_A_OUT", action = "http://sap.com/xi/WebService/soap1.1")
    @Oneway
    public void siSEGPPMSCAKJXYREQAOUT(
        @WebParam(partName = "MT_SEG_PPMS_CA_KJXY_REQ", name = "MT_SEG_PPMS_CA_KJXY_REQ", targetNamespace = "urn:seg:ecc:ca:ppms")
        KjxyServiceBean mtSEGPPMSCAKJXYREQ
    );
}