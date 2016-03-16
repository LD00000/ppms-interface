package com.sunway.ws.core.cxf;

import org.apache.cxf.binding.soap.interceptor.ReadHeadersInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.sunway.ws.core.cxf.http.InterfaceHttpBean;
import com.sunway.ws.core.cxf.http.InterfaceHttpDaoImpl;
import com.sunway.ws.core.general.GeneralQuery;

/**
 * cxf 拦截器，拦截 HTTP request/responses 并保存到 i_http
 * 
 * @author lidong
 */
public class HttpInInterceptor extends AbstractPhaseInterceptor<Message> {
	
	private String interfaceName;	// 接口名
	private String type;	// 类型
	
	public HttpInInterceptor() { 
		super(Phase.RECEIVE); 	
		addAfter(ReadHeadersInterceptor.class.getName());
	} 
	
	public HttpInInterceptor(String type, String interfaceName) { 
		super(Phase.RECEIVE); 
		addAfter(ReadHeadersInterceptor.class.getName());
		this.type = type;
		this.interfaceName = interfaceName;
	} 
	
	@Override
	public void handleMessage(Message message) throws Fault {
		final InterfaceHttpBean interfaceHttpBean = new InterfaceHttpBean();
		interfaceHttpBean.setId(GeneralQuery.getDbSeq("seq_interface"));
		interfaceHttpBean.setType(type);
		interfaceHttpBean.setInterfaceName(interfaceName);
		interfaceHttpBean.setInMessage(new MessageHandler().setupXml(message, "in"));
		
		new InterfaceHttpDaoImpl().insert(interfaceHttpBean);
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
	
}
