package com.module.entity.violation.violationExamine;

import lombok.Data;

import java.util.Date;

/**
 * 违规检查Entity
 * Created by huangbotao on 2020/8/28;
 */

@Data
public class ViolationExamine {

    private String violationExamineId; //违规检查id
    private Date createDate;     //创建时间
    private String hospitalId;    //关联违规单位医院
    private Date writeTime;  // 录入时间
    private String way;    //处置方式
    private String content; // 违规内容
    private String status;  // 状态
    private String photograph; // 现场照片
    private Date abarbeitungTime; // 整改时限
    private Date violationTime; // 违规时间

}
