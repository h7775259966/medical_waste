package com.module.entity.warnDispose;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警类型处理Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnDispose {

    private String warnDisposeId;     //预警处理id
    private String warnTypeId;     //预警类型id
    private String conductor;     //处理人
    private String status;     //流程状态
    private String warnReason;     //预警原因
    private String warnSuggestion;     //预警建议
    private Date createDate;     //创建时间
    private String remarks;     //备注
}