package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysVip;
import com.cy.pj.sys.service.SysVipService;

@RequestMapping("/vip")
@RestController
public class SysVipController {

	@Autowired
	private SysVipService sysVipService;
	
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
		PageObject<SysVip> pageObjects = sysVipService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObjects);
	}
}
