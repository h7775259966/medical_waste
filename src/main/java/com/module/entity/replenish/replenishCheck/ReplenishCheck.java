package com.module.entity.replenish.replenishCheck;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医废补录审核Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class ReplenishCheck {

    private String replenishCheckId;        //补录审核id
    private String replenishId;        //补录id
    private String replenishCheckCause;        //补录原因
    private String replenishCheckSuggest;        //补录意见
    private String replenishCheckStatus;        //处理状态
    private Date createDate;                //创建时间
    private String remarks;               //备注

}