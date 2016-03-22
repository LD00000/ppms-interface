package com.sunway.ws.module.common;

/**
 * 数据发送状态
 */
public enum DataStatus {
	
	/**
	 * 成功
	 */
	SUCCESS(0),	
	/**
	 * 失败(会重发)
	 */
	FAILED(1),	
	/**
	 * 失败(失败次数过多,不重发)
	 */
	FAILED_TOO_MANY_TIMES(2),
	/**
	 * 接口未开启或在 i_config 表中无记录
	 */
	WARN_NO_CLIENT(3);
	
	private Integer status;
	
	private DataStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
