package com.sunway.ws.module;

public enum WSInterface {
	
	/** ERP 采购计划反馈接口 **/
	ERP_CGJH_FEEDBACK("erp_cgjh_feedback"),
	/** ERP 采购合同接口 **/
	ERP_CGHT("erp_cght"),
	/** ERP 框架协议接口 **/
	ERP_KJXY("erp_kjxy"),
	/** ERP 出库单接口 **/
	ERP_CKD("erp_ckd"),
	/** ERP 入库单接口 **/
	ERP_RKD("erp_rkd"),
	/** ERP 里程碑接口 **/
	ERP_LCB("erp_lcb");
	
	private String name;
	
	private WSInterface(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
