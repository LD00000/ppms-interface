package com.sunway.ws.module.erp.business.kjxy.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<KjxyServiceBean> getPushErpKjxy() {
		List<KjxyServiceBean> kjxyServiceBeans = new ArrayList<KjxyServiceBean>();
		
		KjxyBean kjxyQ = new KjxyBean();
		kjxyQ.setStatus("1");
		List<KjxyBean> kjxys = kjxyDao.queryForList(kjxyQ);
		for (KjxyBean kjxy : kjxys) {
			KjxyServiceBean kjxyService = new KjxyServiceBean();
			kjxyService.setIsmsghead(new MsgHead());
			
			kjxyService.setIsekohead(kjxy);
			kjxyService.setItekoitem(kjxyItemDao.queryForListByHeadId(kjxy.getId()));
			
			kjxyServiceBeans.add(kjxyService);
		}
		
		return kjxyServiceBeans;
	}
	
}
