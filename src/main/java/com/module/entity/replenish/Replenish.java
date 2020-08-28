package com.module.entity.replenish;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医废补录Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Replenish {

    private String replenishId;        //补录id
    private String userId;        //补录人
    private String officeId;        //科室id
    private String nurseId;        //护士id
    private String collectId;        //收集人id
    private String trashId;        //医废类型id
    private String replenishNumber;        //医废数量
    private String replenishWeight;        //医废重量
    private String checkStatus;        //补录审核状态
    private String warehouseStatus;        //出入库状态
    private Date replenishTime;                //补录时间
    private Date collectTime;                //收集时间
    private Date createDate;                //创建时间
    private String remarks;               //备注

}