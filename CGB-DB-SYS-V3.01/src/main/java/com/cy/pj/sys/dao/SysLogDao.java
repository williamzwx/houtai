package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;

@Mapper
public interface SysLogDao {

	/**
	 * 添加日志
	 * @param entity
	 * @return
	 */
	int insertObject(SysLog entity);
	/**
	 * 根据id删除日志
	 * @param ids
	 * @return
	 */
	int deleteObjects(@Param("ids")Integer... ids);
	/**
	 *  实现分页查询
	 * @param usrname 查询条件
	 * @param pageSize 表示页面大小
	 * @param startIndex 表示起始位置
	 * @return
	 */
	List<SysLog> findPageObjects(@Param("username")String username,
								 @Param("pageSize")Integer pageSize,
								 @Param("startIndex")Integer startIndex);
	/**
	 * 查询总记录数 
	 * @param username 查询条件 
	 * @return
	 */
	int getRowCount(@Param("username")String username);
	
	
}
