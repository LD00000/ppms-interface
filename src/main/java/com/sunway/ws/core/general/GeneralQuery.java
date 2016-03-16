package com.sunway.ws.core.general;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.sunway.ws.core.utils.SpringUtils;
import com.sunway.ws.module.common.bean.InterfaceConfigBean;

/**
 * 通用查询类
 * 
 * @author lidong
 *
 */
@Component
@Lazy(true)
public class GeneralQuery {
	
	private static SqlSession sqlSession = SpringUtils.getBean("sqlSession");
	private static GeneralQueryInterface generalQuery = sqlSession.getMapper(GeneralQueryInterface.class);
	
	/**
	 * 根据名字取接口配置信息
	 * 
	 * @param name
	 * @return
	 */
	public static final InterfaceConfigBean getInterfaceConfig(String name) {
		return generalQuery.getInterfaceConfig(name);
	}
	
	/**
	 * 取接口配置信息
	 * 
	 * @param name
	 * @return
	 */
	public static final List<InterfaceConfigBean> getAllInterfaceConfig() {
		return generalQuery.getAllInterfaceConfig();
	}
	
	/**
	 * 查询序列
	 * 
	 * @param name
	 * @return
	 */
	public static final Long getDbSeq(String name) {
		return Long.valueOf(generalQuery.getDbSeq(name));
	}
	
}
