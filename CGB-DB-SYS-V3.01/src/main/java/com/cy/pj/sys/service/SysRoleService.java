package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	List<CheckBox> findObjects();
	int updateObject(SysRole entity,Integer[] menuId);
	SysRoleMenuVo findObjectById(Integer id);
	int saveObject(SysRole entity,Integer[] menuId);
	PageObject<SysRole> findPageObjects(String name,
										Integer pageCurrent);
	void deleteObject(Integer id);
}
