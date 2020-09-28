package com.module.entity.hospitalSwitch;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 重量阈值功能开关Entity
 * @author zx
 * @version 2020/9/28
 */

@Data
@ToString
public class SwitchWeight {

    private String hospitalId;		//所属医院id
    private int warnInWeight;       //入库重量阈值(单位:%)
    private int warnOutWeight;     //出库重量阈值(单位:%)
    private Date createDate;		//创建时间
}