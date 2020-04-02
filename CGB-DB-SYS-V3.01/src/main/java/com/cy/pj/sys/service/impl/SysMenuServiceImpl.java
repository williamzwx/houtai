package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService{

	@Autowired
	private SysMenuDao sysMenuDao;
	//@RequiresPermissions("sys:menu:view")
	@RequiredLog("查询菜单")
	@Override
	public List<Map<String, Object>> findObjects() {
		//1.查询记录
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if(list==null||list.size()==0)
			throw new ServiceException("没有对应记录");
		//2.返回查询结果
		return list;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Node> findZTreeMenuNodes() {

		return sysMenuDao.findZTreeMenuNodes();
	}
	@RequiredLog("新增菜单")
	@Override
	public int saveObject(SysMenu entity) {
		//1.参数校验
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("保存菜单名不能为空");
		if(entity.getParentId()<1)
			throw new ServiceException("必须分配上级菜单");
		//2.执行保存
		int rows = sysMenuDao.insertObject(entity);
		//3.返回结果
		return rows;
	}
	@Override
	public int updateObject(SysMenu entity) {
		//1.参数校验
		if(entity==null)
			throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("保存菜单名不能为空");
		if(entity.getParentId()<1)
			throw new ServiceException("必须分配上级菜单");
		//2.执行保存
		int rows = sysMenuDao.updateObject(entity);
		//3.返回结果
		return rows;
	}
	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null||id<1)
			throw new IllegalArgumentException("参数不正确");
		//2.执行删除操作
		int rows = sysMenuDao.deleteObjects(id);
		//3.返回执行结果
		return rows;
	}

}
