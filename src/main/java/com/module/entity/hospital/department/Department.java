package com.module.entity.hospital.department;

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
    private Date createDate;		//创建时间
    private String remarks;		//备注
    private String hospitalId;    //关联查询医院ID

}