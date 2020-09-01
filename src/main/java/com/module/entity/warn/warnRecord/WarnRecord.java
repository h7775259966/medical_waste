package com.module.entity.warn.warnRecord;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警记录Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnRecord {

    private String warnRecordId;      //预警记录id
    private String warnTypeId;      //预警类型id
    private String warnPlace;      //预警地点
    private String warnContent;      //预警内容
    private String code;      //条形码标识
    private Date warnTime;      //预警时间
    private Date createDate;      //创建时间
    private String remarks;      //备注
}