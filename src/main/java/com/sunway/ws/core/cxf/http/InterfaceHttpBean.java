package com.sunway.ws.core.cxf.http;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="i_http")
public class InterfaceHttpBean {
	
	@Id
	private Long id;
	private String type;
	private String interfaceName;
	private String inMessage;
	private String outMessage;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getInMessage() {
		return inMessage;
	}
	public void setInMessage(String inMessage) {
		this.inMessage = inMessage;
	}
	public String getOutMessage() {
		return outMessage;
	}
	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
