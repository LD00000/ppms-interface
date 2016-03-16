package com.sunway.ws.module.erp.business.cght.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.cght.bean.CghtBean;
import com.sunway.ws.module.erp.business.cght.bean.CghtItemBean;
import com.sunway.ws.module.erp.business.cght.bean.CghtPayBean;
import com.sunway.ws.module.erp.business.cght.bean.CghtServiceBean;
import com.sunway.ws.module.erp.business.cght.dao.CghtDao;
import com.sunway.ws.module.erp.business.cght.dao.CghtItemDao;
import com.sunway.ws.module.erp.business.cght.dao.CghtPayDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

/**
 * 采购合同 service
 */
@Service
public class CghtService {
	
	@Autowired
	private CghtDao cghtDao;
	@Autowired
	private CghtItemDao cghtItemDao;
	@Autowired
	private CghtPayDao cghtPayDao;
	
	/**
	 * 从中间表获得推送 ERP 的采购合同数据
	 * 
	 * @return
	 */
	public List<CghtServiceBean> getPushErpCghts() {
		final List<CghtServiceBean> cghtServiceBeans = new ArrayList<CghtServiceBean>();
		
		final CghtBean cghtQ = new CghtBean();
		cghtQ.setStatus("1");
		final List<CghtBean> cghts = cghtDao.queryForList(cghtQ);
		
		for (CghtBean cght : cghts) {
			CghtServiceBean cghtServiceBean = new CghtServiceBean();
			cghtServiceBean.setIsmsghead(new MsgHead());
			
			// 主表信息
			cghtServiceBean.setIsheader(cght);

			Long headId = cght.getId();
			// 明细
			List<CghtItemBean> cghtItems = cghtItemDao.queryForListByHeadId(headId);
			cghtServiceBean.setItitems(cghtItems);
			
			// 付款
			List<CghtPayBean> cghtPays = cghtPayDao.queryForListByHeadId(headId);
			cghtServiceBean.setItpay(cghtPays);
			
			cghtServiceBeans.add(cghtServiceBean);
		}
		
		return cghtServiceBeans;
	}
	
	/**
	 * 根据合同编码获得推送 ERP 的采购合同
	 * 
	 * @param htbm 合同编码
	 * @return
	 */
	public CghtServiceBean getPushErpCght(String htbm) {
		final CghtBean cght = cghtDao.getPushErpCght(htbm);
		if (cght == null)
			return null;
		
		final CghtServiceBean cghtServiceBean = new CghtServiceBean();
		
		cghtServiceBean.setIsmsghead(new MsgHead());
		cghtServiceBean.setIsheader(cght);
		cghtServiceBean.setItitems(cghtItemDao.getPushErpCghtItems(htbm));
		cghtServiceBean.setItpay(cghtPayDao.getPushErpCghtPays(htbm));
		
		return cghtServiceBean;
	}
	
}
