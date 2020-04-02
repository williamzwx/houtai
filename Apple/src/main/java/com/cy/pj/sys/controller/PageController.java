package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {

	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "index";
	}
	
	/**返回各模块的UI页面*/
	 @RequestMapping("{moduleUI}")
	 public String doModuleUI(@PathVariable String moduleUI) {
		 return moduleUI;
	 }
}
