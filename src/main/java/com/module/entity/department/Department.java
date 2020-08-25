package com.module.entity.department;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医院部门Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Department{

	private String departmentId;		// 部门id
	private String departmentName;		// 部门名称
    private Date creatDate;		//创建时间
    private String remark;		//备注

}