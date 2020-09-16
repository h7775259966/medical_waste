package com.module.entity.hospital.nurse;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 医院护士Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Nurse {

    private String nurseId;         //护士id
    private String nurseName;		// 护士名称
    private String nurseCode;     //护士条形码
    private String departmentId;		// 所属部门id
    private String officeId;		// 所属科室id
    private Date createDate;		//创建时间
    private String remarks;		//备注
    private String DepartmentName;      //所属部门名称DepartmentName字段仅在前端展示数据时使用
    private String officeName;      //所属科室名称officeName字段仅在前端展示数据时使用
}