package com.sunway.ws.core.cxf;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * webservice 监听器， 将 HTTP Request 存入数据库 i_http 表
 */
public class WsRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent requestEvent) {
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException("Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
        }
		
		StringBuilder requestStr = new StringBuilder();
		
		HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();
		
		// 头信息
		Enumeration<String> em = request.getHeaderNames();	
		while(em.hasMoreElements()) {
			String name = em.nextElement();
			String value = request.getHeader(name);
			requestStr.append(name + ":" + value + "\n");
		}
		
		// 正文
		requestStr.append("\n");
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keySet = map.keySet();  
		for (String key : keySet) {  
			String[] values = (String[]) map.get(key);  
			for (String value : values) {  
				requestStr.append(key + ":" + value + "\n");  
			} 
		}
		
		
		
		
//		try {
//			ServletInputStream servletInputStream = request.getInputStream();
//			servletInputStream.
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println("request   " + requestStr);
		
		System.out.println("---------");
		BufferedReader a = null;
		try {
			a = request.getReader();
			String rString;
			while((rString = a.readLine()) != null) {
				System.out.println(rString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				a.close();
			} catch (IOException e) {
			}
		}
		
		
		
		// 存入数据库
//		final InterfaceHttpBean interfaceHttpBean = new InterfaceHttpBean();
//		interfaceHttpBean.setId(GeneralQuery.getDbSeq("SEQ_INTERFACE_HTTP"));
//		interfaceHttpBean.setType(type);
//		interfaceHttpBean.setInterfaceName(interfaceName);
//		interfaceHttpBean.setInMessage(requestStr.toString());
//		
//		new InterfaceHttpDaoImpl().insert(interfaceHttpBean);
	}

}
