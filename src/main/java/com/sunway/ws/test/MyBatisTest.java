package com.sunway.ws.test;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MyBatisTest {
	
	@Select("select 1 from dual")   
	String queryDual(@Param("userId") String userId); 

}
