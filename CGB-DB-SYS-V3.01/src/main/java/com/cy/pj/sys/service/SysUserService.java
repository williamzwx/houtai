package com.cy.pj.sys.service;

import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.vo.SysUserDeptVo;

public interface SysUserService {
	
	int updatePassword(String password,String newPassword,String cfgPassword);
	int updateObject(SysUser entity,Integer[] roleIds);
	Map<String, Object> findObjectById(Integer userId);
	int saveObject(SysUser entity,Integer[] roleIds);

	int validById(Integer id,Integer valid,String modifiedUser);
	/**
	 *  分页查询当前页记录信息
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUserDeptVo> findPageObjects(
			String username,Integer pageCurrent);
}
