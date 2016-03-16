package com.sunway.ws.module.common.bean;

import javax.persistence.Id;
import javax.persistence.Table;

import com.sunway.ws.module.common.DataStatus;

@Table(name="I_DATA_STATUS")
public class InterfaceDataStatusBean {
	
	@Id
	private Long id;
	private String interfaceName;	// 接口名
	private String bPk;	// 业务数据主键
	private String bPkExt1;	// 业务数据联合主键拓展1
	private String bPkExt2;	// 业务数据联合主键拓展2
	private Integer status;	// 数据发送状态 0-成功 1-失败(会重发) 2-失败(失败次数过多,不重发)
	private Integer retryTimes;	// 重发次数
	private String exception;	// 异常
	
	public InterfaceDataStatusBean(String interfaceName) {
		this.interfaceName = interfaceName;
		this.status = DataStatus.FAILED.getStatus();
		this.retryTimes = 0;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInterfaceName() {
		return interfaceName;
	}
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	public String getbPk() {
		return bPk;
	}
	public void setbPk(String bPk) {
		this.bPk = bPk;
	}
	public String getbPkExt1() {
		return bPkExt1;
	}
	public void setbPkExt1(String bPkExt1) {
		this.bPkExt1 = bPkExt1;
	}
	public String getbPkExt2() {
		return bPkExt2;
	}
	public void setbPkExt2(String bPkExt2) {
		this.bPkExt2 = bPkExt2;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRetryTimes() {
		return retryTimes;
	}
	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}

}
