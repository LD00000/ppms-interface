package com.sunway.ws.module.erp.business.rkd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.rkd.bean.RkdBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdItemBean;
import com.sunway.ws.module.erp.business.rkd.bean.RkdServerBean;
import com.sunway.ws.module.erp.business.rkd.dao.RkdDao;
import com.sunway.ws.module.erp.business.rkd.dao.RkdItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class RkdService {
	
	@Autowired
	private RkdDao rkdDao;
	@Autowired
	private RkdItemDao rkdItemDao;
	
	/**
	 * 推送 ERP 采购合同创建接口的数据
	 * 
	 * @return
	 */
	public List<RkdServerBean> getPushErpRkd() {
		List<RkdServerBean> rkdServerBeans = new ArrayList<RkdServerBean>(); 
		
		RkdBean rkdQ = new RkdBean();
		rkdQ.setStatus("1");
		List<RkdBean> rkds = rkdDao.queryForList(rkdQ);
		for (RkdBean rkd : rkds) {
			RkdServerBean rkdServerBean = new RkdServerBean();
			rkdServerBean.setIsmsghead(new MsgHead());
			
			// 主表信息
			rkdServerBean.setIsheader(rkd);
			
			// 明细
			List<RkdItemBean> rkdItems = rkdItemDao.queryForListByHeadId(rkd.getId());
			rkdServerBean.setItitems(rkdItems);
			
			rkdServerBeans.add(rkdServerBean);
		}
		
		return rkdServerBeans;
	}

}
