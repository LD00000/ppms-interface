package com.sunway.ws.module.erp.business.feedback.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
public class Message extends BaseBean {

	@Transient
	private static final long serialVersionUID = 978559376548826882L;

	private String type;
	private String id;
	private String number;
	private String message;
	private String log_no;
	private String log_msg_no;
	private String message_v1;
	private String message_v2;
	private String message_v3;
	private String message_v4;
	private String parameter;
	private String row;
	private String field;
	private String system;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLog_no() {
		return log_no;
	}
	public void setLog_no(String log_no) {
		this.log_no = log_no;
	}
	public String getLog_msg_no() {
		return log_msg_no;
	}
	public void setLog_msg_no(String log_msg_no) {
		this.log_msg_no = log_msg_no;
	}
	public String getMessage_v1() {
		return message_v1;
	}
	public void setMessage_v1(String message_v1) {
		this.message_v1 = message_v1;
	}
	public String getMessage_v2() {
		return message_v2;
	}
	public void setMessage_v2(String message_v2) {
		this.message_v2 = message_v2;
	}
	public String getMessage_v3() {
		return message_v3;
	}
	public void setMessage_v3(String message_v3) {
		this.message_v3 = message_v3;
	}
	public String getMessage_v4() {
		return message_v4;
	}
	public void setMessage_v4(String message_v4) {
		this.message_v4 = message_v4;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
