package com.module.entity.hospital.office;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医院科室Entity
 * @author zx
 * @version 2020-08-26
 */

@Data
@ToString
public class Office {

	private String officeId;		//科室id
    private String departmentId;    //所属部门id
	private String officeName;		//科室名称
    private Date createDate;		//创建时间
    private String remarks;		//备注
    private String DepartmentName;      //所属部门名称DepartmentName字段仅在前端展示数据时使用

}