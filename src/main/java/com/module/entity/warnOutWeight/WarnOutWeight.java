package com.module.entity.warnOutWeight;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 出库重量预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnOutWeight {

	private String warnOutWeightId;		//出库重量预警id
    private String status;		    //流程状态
    private String monitorId;		//监测点id
    private String caseNum;		    //转运箱编号
    private String inWeight;		//入库重量
    private String outWeight;		//出库重量
    private String outPerson;		//出库人员
    private Date outTime;		//出库日期
    private Date warnTime;		//预警日期
    private Date createDate;		//创建时间
    private String remarks;		//备注

}