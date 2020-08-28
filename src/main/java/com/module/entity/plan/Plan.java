package com.module.entity.plan;

import lombok.Data;

import java.util.Date;

/**
 * Created by huangbotao on 2020/8/27;
 */

@Data
public class Plan {

    private String planId;       //上报计划id
    private Date createDate;     //创建时间
    private String planName;     //计划名称
    private Date writeTime;      //发布时间
    private String writeUnit;    //发布单位
    private String content;      //上报内容
    private Integer hospitalId;   //上报医院
    private Integer finishNumber;  //完成数
    private Integer unfinishNumber;//未完成数
    private String status;         //状态
    private String remark;         //备注

}