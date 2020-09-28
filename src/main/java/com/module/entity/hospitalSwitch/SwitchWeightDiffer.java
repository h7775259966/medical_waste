package com.module.entity.hospitalSwitch;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 重量差值功能开关Entity
 * @author zx
 * @version 2020/9/28
 */

@Data
@ToString
public class SwitchWeightDiffer {

    private String hospitalId;		//所属医院id
    private int smallWeight;        //最小差值
    private int bigWeight;          //最大差值
    private Date createDate;	    //创建时间

}