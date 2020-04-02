package com.cy.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtil;
import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;

@RestController
@RequestMapping("/user/")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doGetLoginUser")
	  public JsonResult doGetLoginUser() {
		  return new JsonResult(ShiroUtil.getUser());
	  }

	@RequestMapping("doLogin")
	public JsonResult doLogin(
			String username,
			String password,
			boolean isRememberMe) {
		//封装用户名和密码
		UsernamePasswordToken token=
				new UsernamePasswordToken(username, password);
		if(isRememberMe)token.setRememberMe(true);
		//提交用户名和密码
		Subject subject=SecurityUtils.getSubject();
		subject.login(token);//提交给securityManager

		return new JsonResult("login ok");
	}
	@RequestMapping("doUpdatePassword")
	public JsonResult doUpdatePassword(
			String pwd,
			String newPwd,
			String cfgPwd) {
		sysUserService.updatePassword(pwd, newPwd, cfgPwd);
		return new JsonResult("update ok");
	}
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysUser entity,Integer[] roleIds) {
		sysUserService.updateObject(entity, roleIds);
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id){
		Map<String, Object> user = sysUserService.findObjectById(id);
		return new JsonResult(user);
	}
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysUser entity,Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
	}
	@RequestMapping("doValidById")
	public JsonResult doValidById(Integer id,Integer valid) {
		sysUserService.validById(id, valid, "admin");
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,
			Integer pageCurrent) {
		PageObject<SysUserDeptVo> pageObject = 
				sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}
}
