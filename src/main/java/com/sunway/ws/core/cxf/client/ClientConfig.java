package com.sunway.ws.core.cxf.client;

/**
 * cxf 客户端配置
 */
public class ClientConfig {
	
	protected String address;	// wsdl 地址
	protected String method;	// 方法名
	protected Class<?> serverClass;	// 服务端接口实现类
	protected String username;	// 用户名
	protected String password;	// 密码
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Class<?> getServerClass() {
		return serverClass;
	}
	public void setServerClass(Class<?> serverClass) {
		this.serverClass = serverClass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
