package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;

@Mapper
public interface SysMenuDao {

	/**
	 * 删除菜单
	 * @param ids
	 * @return
	 */
	@Delete("delete from sys_menus where id=#{id}")
	int deleteObjects(Integer id);
	/**
	 * 更新菜单数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	/**
	    *  将菜单信息持久化到数据库
	  * @param entity
	  * @return
	  */
	int insertObject(SysMenu entity);
	/**
	 * 添加菜单时回显菜单选项
	 */
	@Select("select id,name,parentId from sys_menus")
	List<Node> findZTreeMenuNodes();
	
	/**
	   * 查询所有的菜单以及菜单对应的上级菜单信息
	   * 要求:一行记录映射为内存中一个map对象.
	   * 说明:在很多优秀的产品级应用中其实不推荐
	   * 直接基于map做映射存储,因为第一可读性相对较差,
	   * 第二它的值的类型不可控.但是有时为提高开发的
	   * 速度,map就可以直接作为映射存储对象.尤其是
	   * 一些外包项目.
	 * @return
	 */
	List<Map<String, Object>> findObjects();
	List<String> findPermissions(Integer[] array);
}
