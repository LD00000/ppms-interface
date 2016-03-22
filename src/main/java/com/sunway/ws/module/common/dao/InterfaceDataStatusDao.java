package com.sunway.ws.module.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.UpdateProvider;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.core.persistence.provider.InsertSqlProvider;
import com.sunway.ws.core.persistence.provider.UpdateSqlProvider;
import com.sunway.ws.module.common.bean.InterfaceDataStatusBean;

@MyBatisDao
public interface InterfaceDataStatusDao {
	
	@InsertProvider(type=InsertSqlProvider.class, method="insert")
	@SelectKey(statement="SELECT SEQ_I_DATA_STATUS.NEXTVAL FROM DUAL", before = true, keyProperty = "id", resultType = long.class)
	public int insert(InterfaceDataStatusBean interfaceDataStatusBean);
	
	@Select("SELECT ID, INTERFACE_NAME, B_PK, B_PK_EXT1, B_PK_EXT2, STATUS, RETRY_TIMES, EXCEPTION FROM I_DATA_STATUS WHERE STATUS = 1")
	public List<InterfaceDataStatusBean> queryRetryData();
	
	@UpdateProvider(type=UpdateSqlProvider.class, method="update")
	public void update(InterfaceDataStatusBean interfaceDataStatusBean);

}
