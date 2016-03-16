package com.sunway.ws.module.common.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sunway.ws.core.bean.BaseBean;

/**
 * 接口配置 bean
 */
@Table(name = "I_CONFIG")
public class InterfaceConfigBean extends BaseBean {
	
	@Transient
	private static final long serialVersionUID = 7310880021388831133L;

	/** 主键 **/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/** 接口名 **/
	private String name;
	/** quartz 调用时间 **/
	private String time;
	/** 地址 **/
	private String address;
	/** 方法名 **/
	private String method;
	/** 是否开启（0-关 1-开） **/
	private String enabled;
	/** 用户名 **/
	private String username;
	/** 密码 **/
	private String password;
	/** 描述 **/
	private String des;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
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
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
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
