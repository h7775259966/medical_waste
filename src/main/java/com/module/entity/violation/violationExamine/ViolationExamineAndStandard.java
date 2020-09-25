package com.module.entity.violation.violationExamine;

import com.module.entity.violation.violationStandard.ViolationStandard;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 给违规检查分配违规标准(中间表)Entity
 * Created by huangbotao on 2020/8/28;
 */

@Data
public class ViolationExamineAndStandard {

    private String id;      //主键
    private String violationExamineId;     //违规检查id
    private String violationStandardId;  //违规标准id
    private Date createDate;		//创建时间

}
