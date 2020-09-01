package com.module.entity.warnInWeight;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 入库重量预警Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnInWeight {

    private String warnInWeightId;       //入库重量预警id
    private String departmentId;       //部门id
    private String officeId;       //科室id
    private String code;       //条形码标识
    private String inWeight;       //入库重量
    private String collectWeight;       //收集重量
    private String trashId;       //废物类型
    private String inPerson;       //入库人员
    private String collectId;       //移交人员id
    private Date inTime;       //入库日期
    private Date warnTime;       //预警日期
    private Date createDate;       //创建时间
    private String remarks;       //备注

}