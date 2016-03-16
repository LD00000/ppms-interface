package com.sunway.ws.module.erp.business.cgjh.bean;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.sunway.ws.core.bean.BaseBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "id",
    "number",
    "message",
    "logno",
    "logmsgno",
    "messagev1",
    "messagev2",
    "messagev3",
    "messagev4",
    "parameter",
    "row",
    "field",
    "system"
})
public class CgjhMessage extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = 2889454502813956249L;

	@XmlElement(name = "TYPE")
    protected String type;
    @XmlElement(name = "ID")
    protected String id;
    @XmlElement(name = "NUMBER")
    protected String number;
    @XmlElement(name = "MESSAGE")
    protected String message;
    @XmlElement(name = "LOG_NO")
    protected String logno;
    @XmlElement(name = "LOG_MSG_NO")
    protected String logmsgno;
    @XmlElement(name = "MESSAGE_V1")
    protected String messagev1;
    @XmlElement(name = "MESSAGE_V2")
    protected String messagev2;
    @XmlElement(name = "MESSAGE_V3")
    protected String messagev3;
    @XmlElement(name = "MESSAGE_V4")
    protected String messagev4;
    @XmlElement(name = "PARAMETER")
    protected String parameter;
    @XmlElement(name = "ROW")
    protected String row;
    @XmlElement(name = "FIELD")
    protected String field;
    @XmlElement(name = "SYSTEM")
    protected String system;
    
    public CgjhMessage() {
    	setSystem("PPMS");
    }
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getLogno() {
		return logno;
	}
	public void setLogno(String logno) {
		this.logno = logno;
	}
	public String getLogmsgno() {
		return logmsgno;
	}
	public void setLogmsgno(String logmsgno) {
		this.logmsgno = logmsgno;
	}
	public String getMessagev1() {
		return messagev1;
	}
	public void setMessagev1(String messagev1) {
		this.messagev1 = messagev1;
	}
	public String getMessagev2() {
		return messagev2;
	}
	public void setMessagev2(String messagev2) {
		this.messagev2 = messagev2;
	}
	public String getMessagev3() {
		return messagev3;
	}
	public void setMessagev3(String messagev3) {
		this.messagev3 = messagev3;
	}
	public String getMessagev4() {
		return messagev4;
	}
	public void setMessagev4(String messagev4) {
		this.messagev4 = messagev4;
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

}
