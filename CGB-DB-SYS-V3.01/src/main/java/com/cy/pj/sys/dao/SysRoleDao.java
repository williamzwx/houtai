package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Mapper
public interface SysRoleDao {

	/**
	 * 角色查询
	 * @return
	 */
	List<CheckBox> findObjects();
	/**
	 * 删除角色信息
	 * @param id
	 */
	/**
	 * 基于角色删除角色自身信息
	 * @param id
	 * @return
	 */
	@Delete("delete from sys_roles where id=#{id}")
	void deleteObject(Integer id);
	/**
	 * 更新角色信息
	 */
	int updateObject(SysRole entity);
	/**
	 *   基于角色id查询角色以及角色对应的菜单id
	 *   并将结果封装到SysRoleMenuVo对象
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	/**
	 * 插入新的角色
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	/**
	 * 获取总的记录数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	/**
	 * 分页查询
	 * @param name
	 * @param pageCurrent
	 * @param startIndex
	 * @return
	 */
	List<SysRole> findPageObjects(@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
