package com.sunway.ws.module.erp.business.kjxy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunway.ws.module.erp.business.kjxy.bean.KjxyBean;
import com.sunway.ws.module.erp.business.kjxy.bean.KjxyServiceBean;
import com.sunway.ws.module.erp.business.kjxy.dao.KjxyDao;
import com.sunway.ws.module.erp.business.kjxy.dao.KjxyItemDao;
import com.sunway.ws.module.erp.common.bean.MsgHead;

@Service
public class KjxyService {
	
	@Autowired
	private KjxyDao kjxyDao;
	@Autowired
	private KjxyItemDao kjxyItemDao;
	
	/**
	 * 根据框架协议编号获得推送 ERP 的框架协议
	 * 
	 * @param kjxybh 框架协议编号
	 * @return
	 */
	public KjxyServiceBean getPushErpKjxy(final String kjxybh) {
		final KjxyBean kjxy = kjxyDao.queryPushErpKjxy(kjxybh);
		if (kjxy == null)
			return null;
		
		final KjxyServiceBean kjxyServiceBean = new KjxyServiceBean();
		
		kjxyServiceBean.setIsmsghead(new MsgHead());
		kjxyServiceBean.setIsekohead(kjxy);
		kjxyServiceBean.setItekoitem(kjxyItemDao.queryPushErpKjxyItems(kjxybh));
		
		return kjxyServiceBean;
	}
	
}
