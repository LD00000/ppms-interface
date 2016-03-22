package com.sunway.ws.module.erp.common.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sunway.ws.module.WSInterface;
import com.sunway.ws.module.erp.business.cght.service.CghtService;
import com.sunway.ws.module.erp.business.ckd.service.CkdService;
import com.sunway.ws.module.erp.business.kjxy.service.KjxyService;
import com.sunway.ws.module.erp.business.lcb.service.LcbService;
import com.sunway.ws.module.erp.business.rkd.service.RkdService;
import com.sunway.ws.module.erp.common.consumer.ErpConsumerFactory;

/**
 * 业务系统推送数据到 ERP 接口
 */
@RestController
@RequestMapping("/erp")
public class PushDataInterface {
	
	private static final Logger logger = LogManager.getLogger(PushDataInterface.class);
	
	@Autowired
	private CghtService cghtService;
	@Autowired
	private KjxyService kjxyService;
	@Autowired
	private CkdService ckdService;
	@Autowired
	private RkdService rkdService;
	@Autowired
	private LcbService lcbService;
	
	/**
	 * 推送合同
	 * 
	 * @param htbm 合同编码
	 */
	@RequestMapping(value="/cght", method=RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@ResponseBody
	public void pushCght(@RequestBody String htbm) {
		logger.info("向 ERP 推送合同，合同编码：{}", htbm);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_CGHT)
						  .prepareData(cghtService.getPushErpCght(htbm), htbm)
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
		logger.info("向 ERP 推送框架协议，框架协议编号：{}", kjxybh);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_KJXY)
						  .prepareData(kjxyService.getPushErpKjxy(kjxybh), kjxybh)
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
		logger.info("向 ERP 推送出库单，制单编号：{}", zdbh);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_CKD)
						  .prepareData(ckdService.getPushErpCkd(zdbh), zdbh)
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
		logger.info("向 ERP 推送入库单，制单编号：{}", zdbh);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_RKD)
						  .prepareData(rkdService.getPushErpRkd(zdbh), zdbh)
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
		logger.info("向 ERP 推送里程碑，请购单编码：{}", qgdbm);
		
		ErpConsumerFactory.getConsumer(WSInterface.ERP_LCB)
						  .prepareData(lcbService.getPushErpLcb(qgdbm), qgdbm)
						  .run();
	}

}
