package com.sunway.ws.core.general;

import org.apache.ibatis.jdbc.SQL;

public class GeneralQuerySql {
	
	/**
	 * 查询序列 sql
	 * 
	 * @param name
	 * @return 
	 */
	public String getDbSeqSql(String name) {
		return new SQL().SELECT(name + ".nextval").FROM("dual").toString();
	}

}
