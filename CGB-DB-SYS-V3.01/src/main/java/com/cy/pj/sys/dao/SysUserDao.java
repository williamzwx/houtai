package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	
	SysUser findUserByUserName(String username);
	
	int updatePassword(@Param("password")String password,
					   @Param("salt")String salt,
					   @Param("id")Integer id);
	/*
	 * 更新用户数据
	 */
	int updateObject(SysUser entity);
	/**
	 * 修改页面数据呈现
	 * @param id
	 * @return
	 */
	SysUserDeptVo findObjectById(Integer id);
	/**
	 * 用户新增
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	/**
	 * 用户禁用启用操作
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(@Param("id")Integer id,
				  @Param("valid")Integer valid,
				  @Param("modifiedUser")String modifiedUser);
	/**
	 * 基于条件查询用户总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username")String username);
	/**
	 * 基于条件查询当前页要呈现的记录
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptVo> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
