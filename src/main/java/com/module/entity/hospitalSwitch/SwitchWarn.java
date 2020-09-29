package com.module.entity.hospitalSwitch;

import com.module.entity.warn.warnDamaged.WarnDamaged;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警功能开关Entity
 * @author zx
 * @version 2020/9/28
 */

@Data
@ToString
public class SwitchWarn {

    private String hospitalId;		//所属医院id
    private int warnDamaged;    //破损预警(开关状态:1为关闭,2为启动)
    private int warnLose;       //遗失预警
    private int warnLeakage;    //泄漏预警
    private int warnNoOut;    //未出预警
    private int warnViolation;    //违规预警
    private int warnInWeight;    //入库重量预警
    private int warnOutWeight;    //出库重量预警
    private int warnInOvertime;    //入库超时预警
    private int warnOutOvertime;    //出库超时预警
    private Date createDate;		//创建时间
}