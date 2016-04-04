package com.sunway.ws.mybatistest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MyBatisTestDao {
	
	@Select("select 1 from dual")   
	String queryDual(@Param("userId") String userId); 

}
