package com.sunway.ws.core.general;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.sunway.ws.core.persistence.annotation.MyBatisDao;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;

@MyBatisDao
public interface GeneralQueryInterface {
	
	/**
	 * 根据名字取接口配置信息
	 * 
	 * @param name
	 * @return
	 */
	@Select("SELECT * FROM I_CONFIG WHERE NAME = #{name}")
	public InterfaceConfigBean getInterfaceConfig(String name);
	
	/**
	 * 取接口配置信息
	 * 
	 * @return
	 */
	@Select("SELECT ID, NAME, ADDRESS, METHOD, USERNAME, PASSWORD, TIME, ENABLED, DES FROM I_CONFIG")
	public List<InterfaceConfigBean> getAllInterfaceConfig();
	
	/**
	 * 查询序列
	 * 
	 * @param name
	 * @return 
	 */
	@SelectProvider(type=GeneralQuerySql.class, method="getDbSeqSql")
	public String getDbSeq(String name);
	
}
