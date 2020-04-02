package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysVip;

public interface SysVipService {

	PageObject<SysVip> findPageObjects(String username,Integer pageCurrent);


}
