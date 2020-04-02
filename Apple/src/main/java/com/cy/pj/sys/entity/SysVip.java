package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysVip implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	private String sex;
	private Integer phone;
	private String adds;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	      
}
