package com.sunway.ws.module.erp.business.ckd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.ckd.bean.CkdBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdItemBean;
import com.sunway.ws.module.erp.business.ckd.bean.CkdServerBean;
import com.sunway.ws.module.erp.business.ckd.dao.CkdDao;
import com.sunway.ws.module.erp.business.ckd.dao.CkdItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class CkdService {
	
	@Autowired
	private CkdDao ckdDao;
	@Autowired
	private CkdItemDao ckdItemDao;
	
	/**
	 * 推送 ERP 采购合同创建接口的数据
	 * 
	 * @return
	 */
	public List<CkdServerBean> getPushErpCkd() {
		List<CkdServerBean> ckdServerBeans = new ArrayList<CkdServerBean>(); 
		
		CkdBean ckdQ = new CkdBean();
		ckdQ.setStatus("1");
		List<CkdBean> ckds = ckdDao.queryForList(ckdQ);
		for (CkdBean ckd : ckds) {
			CkdServerBean ckdServerBean = new CkdServerBean();
			ckdServerBean.setIsmsghead(new MsgHead());
			
			// 主表信息
			ckdServerBean.setIsheader(ckd);
			
			// 明细
			List<CkdItemBean> ckdItems = ckdItemDao.queryForListByHeadId(ckd.getId());
			ckdServerBean.setItitems(ckdItems);
			
			ckdServerBeans.add(ckdServerBean);
		}
		
		return ckdServerBeans;
	}

}
