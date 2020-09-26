package com.module.entity.violation.violationStandard;

import lombok.Data;

import java.util.Date;

/**
 * 违规标准Entity
 * Created by huangbotao on 2020/8/28;
 */

@Data
public class ViolationStandard {

    private String violationStandardId;  //违规标准id
    private Date createDate;             //创建时间
    private String violationStandardName;  //违规名称
    private String punishmentWay;   //处罚方式
    private String administrativePenalty;   //行政处罚
    private String grade;       //违规等级 1 2 3
    private int status;      //状态  启用 1 禁用 0
    private String remark;       //备注
}
