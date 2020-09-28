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
    private String warnTypeId;		//预警类型id
    private int status;		        //开关状态:1为关闭,2为启动
    private Date createDate;		//创建时间

}