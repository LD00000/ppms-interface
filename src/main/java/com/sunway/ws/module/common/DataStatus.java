package com.sunway.ws.module.common;

/**
 * 数据发送状态
 */
public enum DataStatus {
	
	/**
	 * 成功
	 */
	SUCCESS(0, "成功"),	
	/**
	 * 失败(会重发)
	 */
	FAILED(1, "失败(会重发)"),	
	/**
	 * 失败(失败次数过多,不重发)
	 */
	FAILED_TOO_MANY_TIMES(2, "失败(失败次数过多,不重发)"),
	/**
	 * 接口未开启或在 i_config 表中无记录
	 */
	WARN_NO_CLIENT(3, "接口未开启或在 i_config 表中无记录"),
	/**
	 * 手动重发
	 */
	RETRY_MANUAL(4, "手动重发"),
	/**
	 * 未注册数据监听
	 */
	WARN_UNREGISTER_LISTENER(5, "未注册数据监听"),
	/**
	 * message 为 null
	 */
	WARN_MESSAGE_IS_NULL(6, "message 为 null");
	
	private Integer status;
	private String cnName;
	
	private DataStatus(Integer status, String cnName) {
		this.status = status;
		this.cnName = cnName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

}
