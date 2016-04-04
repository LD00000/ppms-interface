package com.sunway.ws.module.erp.common.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.erp.common.consumer.ErpConsumerFactory;

/**
 * 业务系统推送数据到 ERP 接口
 */
@RestController
@RequestMapping("/erp")
public class PushDataInterface {
	
	private static final Logger logger = LogManager.getLogger(PushDataInterface.class);
	
	/**
	 * 推送合同
	 * 
	 * @param htbm 合同编码
	 */
	@RequestMapping(value="/cght", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushCght(@RequestBody String htbm) {
		logger.info("ERP 接口 准备推送合同...");
		ErpConsumerFactory.getConsumer(WSInterface.ERP_CGHT)
						  .setPk(htbm)
						  .run();
	}
	
	/**
	 * 推送框架协议
	 * 
	 * @param kjxybh 框架协议编号
	 */
	@RequestMapping(value="/kjxy", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushKjxy(@RequestBody String kjxybh) {
		logger.info("ERP 接口 准备推送框架协议...");
		ErpConsumerFactory.getConsumer(WSInterface.ERP_KJXY)
						  .setPk(kjxybh)
						  .run();
	}
	
	/**
	 * 推送出库单
	 * 
	 * @param ckdh 出库单号
	 */
	@RequestMapping(value="/ckd", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushCkd(@RequestBody String zdbh) {
		logger.info("ERP 接口 准备推送出库单...");
		ErpConsumerFactory.getConsumer(WSInterface.ERP_CKD)
						  .setPk(zdbh)
						  .run();
	}
	
	/**
	 * 推送入库单
	 * 
	 * @param rkdh 入库单号
	 */
	@RequestMapping(value="/rkd", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushRkd(@RequestBody String zdbh) {
		logger.info("ERP 接口 准备推送入库单...");
		ErpConsumerFactory.getConsumer(WSInterface.ERP_RKD)
						  .setPk(zdbh)
						  .run();
	}
	
	/**
	 * 推送里程碑
	 * 
	 * @param lcbbm 里程碑编码
	 */
	@RequestMapping(value="/lcb", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushLcb(@RequestBody String qgdbm) {
		logger.info("ERP 接口 准备推送里程碑...");
		ErpConsumerFactory.getConsumer(WSInterface.ERP_LCB)
			  			  .setPk(qgdbm)
						  .run();
	}

}
