package com.sunway.ws.module.erp.common.bean;

import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sunway.ws.core.bean.BaseBean;
import com.sunway.ws.core.utils.IdGen;

/**
 * erp msghead bean
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MsgHead extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = 4633375624826351858L;

	@XmlTransient
	private String msgheadid;	// msgheadid
	@XmlElement(name = "MANDT")
	private String mandt;		// 接受数据的ECC系统
	@XmlElement(name = "GUID")
	private String guid;		// 必输，第三方发出消息为必输，外围系统生成GUID，关联反馈消息
	@XmlElement(name = "PROXY_ID")
	private String proxyId;	// ERP发出的消息为必输，ERP系统生成GUID，用于ERP关联消息和监控平台使用
	@XmlElement(name = "SYSTEM_ID")
	private String systemId;	// 必输，调用服务的外围系统号，关联反馈消息
	@XmlElement(name = "OPERATOR")
	private String operator;	// 外部系统调用人
	@XmlElement(name = "SPRAS")
	private String spras;		// 语言编码
	@XmlElement(name = "INTERFACE_ID")
	private String interfaceId;	// 接口名称，可选，PI系统提供
	@XmlElement(name = "SENDER")
	private String sender;		// 发送方，可选，PI系统提供
	@XmlElement(name = "RECIVER")
	private String reciver;		// 接收方，可选，PI系统提供
	@XmlElement(name = "SENDTIME")
	private String sendtime;	// 发送时间，可选，14位，格式：YYYYMMDDHHMMSS
	
	public MsgHead() {
		this.setMsgheadid("1");
		this.setMandt("ECC6.0");
		this.setGuid(IdGen.uuid());
		this.setSystemId("PPMS");
		this.setSendtime((new Date()).toString());
	}
	
	public String getMsgheadid() {
		return msgheadid;
	}
	public void setMsgheadid(String msgheadid) {
		this.msgheadid = msgheadid;
	}
	public String getMandt() {
		return mandt;
	}
	public void setMandt(String mandt) {
		this.mandt = mandt;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getProxyId() {
		return proxyId;
	}
	public void setProxyId(String proxyId) {
		this.proxyId = proxyId;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSpras() {
		return spras;
	}
	public void setSpras(String spras) {
		this.spras = spras;
	}
	public String getInterfaceId() {
		return interfaceId;
	}
	public void setInterfaceId(String interfaceId) {
		this.interfaceId = interfaceId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

}
