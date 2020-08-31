package com.module.entity.warnOutOvertime;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 出库超时预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnOutOvertime {

	private String warnOutOvertimeId;		//出库超时预警id
    private String status;		    //流程状态
    private String monitorId;		//监测点id
    private String outTimeLimit;		    //存放超时时限
    private Date noOutTime;		//未出库完成日期
    private Date warnTime;		//预警日期
    private Date createDate;		//创建时间
    private String remarks;		//备注

}