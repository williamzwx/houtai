package com.cy.pj.sys.entity;

import lombok.Data;

@Data

public class SysVip1 extends BasePojo{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String email;
	private String sex;
	private String city;
	private Integer score;
	private String school;
	
}
