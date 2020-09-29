package com.module.entity.warn;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 未出预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnNoOut {

	private String warnNoOutId;		    //未出预警id
	private String departmentId;		//部门id
    private String officeId;		    //科室id
    private String warnTimeLimit;		//预警时限
    private String status;		        //流程状态
    private Date noOutTime;		        //未出医废日期
    private Date warnTime;		        //预警日期
    private Date createDate;		    //创建时间
    private String remarks;		        //备注

}