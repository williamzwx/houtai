package com.cy.pj.sys.service;

import java.util.List;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
 
	void saveObject(SysLog entity);
	/**
	 * 删除日志 
	 * @param ids
	 * @return
	 */
	int deleteObjects(Integer... ids);
	/**
	 * 分页查询
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);

}
