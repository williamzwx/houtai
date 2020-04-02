package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysVipDao;
import com.cy.pj.sys.entity.SysVip;
import com.cy.pj.sys.service.SysVipService;

@Service
public class SysVipServiceImpl implements SysVipService{

	@Autowired
	private SysVipDao sysVipDao;
	@Override
	public PageObject<SysVip> findPageObjects(String username, Integer pageCurrent) {
		//1.验证参数
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值不正确！！");
		//2.查询总记录数
		int rowCount = sysVipDao.getRowCount(pageCurrent);
		if(rowCount==0)
			throw new ServiceException("当前页码值不正确！");
		//3.基于条件查询当前页记录
		int pageSize=5;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysVip> records = sysVipDao.findPageObjects(username, startIndex, pageSize);
		//4.封装查询结果并返回
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}

	

}
