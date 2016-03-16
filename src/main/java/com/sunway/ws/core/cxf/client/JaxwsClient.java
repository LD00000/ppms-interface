package com.sunway.ws.core.cxf.client;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.sunway.ws.core.cxf.HttpInInterceptor;
import com.sunway.ws.core.cxf.HttpOutInterceptor;
import com.sunway.ws.core.exception.ClientException;
import com.sunway.ws.core.utils.ClassUtils;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;

/**
 * CXF JAX-WS 客户端
 * 
 * @author lidong
 *
 */
public class JaxwsClient extends ClientConfig {

	public JaxwsClient(String address, String method) {
		this.address = address;
		this.method = method;
	}
	
	public JaxwsClient(String address, String username, String password, Class<?> serviceClass) {
		this.address = address;
		this.serverClass = serviceClass;
		this.username = username;
		this.password = password;
	}
	
	public JaxwsClient(InterfaceConfigBean config, Class<?> serviceClass) {
		this.address = config.getAddress();
		this.serverClass = serviceClass;
		this.username = config.getUsername();
		this.password = config.getPassword();
	} 
	
	/**
	 * 推送数据<br>
	 * 动态生成客户端<br>
	 * 调用工具生成代码，效率不高<br>
	 * 不保存 soap 报文
	 * 
	 * @param obj
	 * @return
	 */
	public Object[] pushByDynamicClientFactory(Object... obj) {
		Object[] objs = null;
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		try {
			Client client = factory.createClient(address);
			objs = client.invoke(method, obj);
		} catch (Exception e) {
			throw new ClientException("调用客户端方法出错..." + "  address: " + address + "  method: " + method, e);
		}
		
		return objs;
	}
	
	/**
	 * 生成 jaxws 客户端对象，需转换成相应的服务端接口实现类<br>
	 * 会保存 soap 报文到 DB
	 * 
	 * @return
	 */
	public Object getClientByJaxWsProxyFactory() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress(address);
		factory.setServiceClass(serverClass);
		factory.getOutInterceptors().add(new HttpOutInterceptor("client", serverClass.getSimpleName()));
		factory.getInInterceptors().add(new HttpInInterceptor("client", serverClass.getSimpleName()));
		factory.setUsername(username);
		factory.setPassword(password);
		return factory.create();
	}
	
	public static <T> void pushByJaxWsProxyFactory(Class<T> wsService, Object client, Object obj) {
		try {
			System.out.println(client.getClass());
			System.out.println(client.getClass().getMethods()[0]);
			System.out.println(ClassUtils.getOriginalClass(client.getClass()));
			ClassUtils.getOriginalClass(client.getClass()).getMethods()[0].invoke(client, obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
