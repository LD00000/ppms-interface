package com.sunway.ws.core.cxf;

import java.util.logging.Logger;

import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

import com.sunway.ws.core.cxf.http.InterfaceHttpBean;
import com.sunway.ws.core.cxf.http.InterfaceHttpDaoImpl;
import com.sunway.ws.core.general.GeneralQuery;

/**
 * cxf 拦截器，拦截 HTTP request/responses 并保存到 i_http
 * 
 * @author lidong
 */
public class HttpOutInterceptor extends AbstractLoggingInterceptor {
	
	private String interfaceName;	// 接口名
	private String type;	// 类型
	
	public HttpOutInterceptor() { 
		super(Phase.PRE_STREAM); 	// PRE_STREAM 流关闭前
		addAfter(SoapOutInterceptor.SoapOutEndingInterceptor.class.getName());
	} 
	
	public HttpOutInterceptor(String type, String interfaceName) { 
		super(Phase.PRE_STREAM); 	// PRE_STREAM 流关闭前
		addAfter(SoapOutInterceptor.SoapOutEndingInterceptor.class.getName());
		this.type = type;
		this.interfaceName = interfaceName;
	} 
	
	@Override
	public void handleMessage(Message message) throws Fault {
		final InterfaceHttpBean interfaceHttpBean = new InterfaceHttpBean();
		interfaceHttpBean.setId(GeneralQuery.getDbSeq("seq_interface"));
		interfaceHttpBean.setType(type);
		interfaceHttpBean.setInterfaceName(interfaceName);
		interfaceHttpBean.setOutMessage(new MessageHandler().setupXml(message, "out"));

		new InterfaceHttpDaoImpl().insert(interfaceHttpBean);	// 插入数据库
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	protected Logger getLogger() {
		return null;
	}
	
}
