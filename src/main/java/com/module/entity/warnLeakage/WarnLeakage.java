package com.module.entity.warnLeakage;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 泄漏预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnLeakage {
    
	private String warnLeakageId;   //泄漏预警id
    private String departmentId;   //部门id
    private String officeId;   //科室id
    private String code;   //条形码标识
    private String collectNumber;   //回收趟次
    private String trashId;   //废物类型
    private String weight;   //物品重量
    private String collectId;   //移交人员id
    private String status;   //流程状态
    private String level;   //流程状态
    private Date collectTime;   //收集时间
    private Date putInTime;   //入库时间
    private Date warnTime;   //预警日期
    private Date createDate;   //创建时间
    private String remarks;   //备注

}