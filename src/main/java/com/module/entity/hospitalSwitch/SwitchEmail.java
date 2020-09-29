package com.module.entity.hospitalSwitch;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 邮件功能开关Entity
 * @author zx
 * @version 2020/9/28
 */

@Data
@ToString
public class SwitchEmail {

    private String hospitalId;		//所属医院id
    private int WarnDamaged;    //破损预警(开关状态:1为关闭,2为启动)
    private int WarnLose;       //遗失预警
    private int WarnLeakage;    //泄漏预警
    private int WarnNoOut;    //未出预警
    private int WarnViolation;    //违规预警
    private int WarnInWeight;    //入库重量预警
    private int WarnOutWeight;    //出库重量预警
    private int WarnInOvertime;    //入库超时预警
    private int WarnOutOvertime;    //出库超时预警
    private Date createDate;		//创建时间

}