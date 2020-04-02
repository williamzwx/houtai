package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import com.cy.pj.sys.entity.SysVip;

@Mapper
public interface SysVipDao {
	List<SysVip> findPageObjects(
			  @Param("username")String username,
			  @Param("startIndex")Integer startIndex,
			  @Param("pageSize")Integer pageSize);//param1,param2,param3
	/**
	 * 查询总记录数
	 */
	int getRowCount(Integer pageCurrent);
}
