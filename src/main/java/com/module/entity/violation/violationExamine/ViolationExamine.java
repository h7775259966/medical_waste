package com.module.entity.violation.violationExamine;

import lombok.Data;

import java.util.Date;

/**
 * Created by huangbotao on 2020/8/28;
 */

@Data
public class ViolationExamine {

    private String violationExamineId;
    private Date createDate;
    private String hospitalId;
    private Date writeTime;
    private String way;
    private String content;
    private String status;
    private String photograph;
    private Date abarbeitungTime;
    private Date violationTime;

}
