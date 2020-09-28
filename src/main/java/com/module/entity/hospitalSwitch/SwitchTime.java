package com.module.entity.hospitalSwitch;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 预警时限功能开关Entity
 * @author zx
 * @version 2020/9/28
 */

@Data
@ToString
public class SwitchTime {

    private String hospitalId;		//所属医院id
    private int warnInOvertime;     //入库超时预警时限(单位:小时)
    private int warnOutOvertime;     //出库超时预警时限(单位:小时)
    private int warnLosetime;     //遗失预警时限(单位:小时)
    private Date createDate;		//创建时间

}