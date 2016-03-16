package com.sunway.ws.module.common.bean;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 接口日志 bean, 记录发送和接收的数据
 */
@Table(name="I_LOG")
public class InterfaceLogBean implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 6412861211080115936L;

	@Id
	private Long id;
	private Integer type;	// 类型, 1-服务端 2-客户端			
	private String interfaceName;	// 接口名
	private String header;	// 报文头信息
	private String payload;	// 报文正文
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	
}
