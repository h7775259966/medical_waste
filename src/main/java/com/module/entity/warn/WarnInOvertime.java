package com.module.entity.warn;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 入库超时预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnInOvertime {

    private String warnInOvertimeId;   //入库超时预警id
    private String monitorId;		//监测点id
    private String outTimeLimit;	//存放超时时限

    private String trashCollectId;  //医废收集id
    private int status;             //流程状态
    private String remarks;         //备注
    private Date warnTime;          //预警日期
    private Date createDate;         //创建时间
}