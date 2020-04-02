package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysRoleMenuDao {
	
	@Delete("delete from sys_role_menus where menu_id=#{menuIds}")
	int deleteObjectsByMenuId(Integer[] menuIds);
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	@Delete("delete from sys_role_menus where role_id=#{roleId}")
	int deleteObjectsByRoleId(Integer roleId);
	/**
	 * 保存角色菜单关系
	 * @param roleId
	 * @param menuId
	 * @return
	 */
	int insertObject(Integer roleId,Integer[] menuIds);
	List<Integer> findMenuIdsByRoleIds(Integer[] array);
}
