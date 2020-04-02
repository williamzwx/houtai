package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogDao sysLogDao;
	
	@RequiredLog("查询日志")
	@Override
	public PageObject<SysLog> findPageObjects(String username,Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值不正确");
		//2.查询总记录数
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("当前记录不存在");
		//3.实现分页查询
		int pageSize = 5;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysLog> records = sysLogDao.findPageObjects(username, pageSize, startIndex);
		//4.封装并返回结果
		return new PageObject<>(pageCurrent, pageSize, rowCount, records);
	}
	@Override
	public int deleteObjects(Integer... ids) {
		//1.参数校验
		if(ids==null||ids.length<1)
			throw new ServiceException("请先选择删除项！");
		//2.执行删除操作
		int rows = sysLogDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("删除失败");
		//3.返回删除结果
		return rows;
	}
	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveObject(SysLog entity) {
		sysLogDao.insertObject(entity);
		
	}

	
}
