package com.module.entity.hospitalSwitch;

import lombok.Data;
import lombok.ToString;

/**医院所有功能开关
 * Created by Zhouxin on 2020/9/29;
 */
@Data
@ToString
public class HospitalSwitch {

    private SwitchEmail switchEmail;                //邮件功能开关Entity
    private SwitchTime switchTime;                  //预警时限功能开关Entity
    private SwitchWarn  switchWarn;                 //预警功能开关Entity
    private SwitchWeight switchWeight;              //重量阈值功能开关Entity
    private SwitchWeightDiffer switchWeightDiffer;  //重量差值功能开关Entity

}