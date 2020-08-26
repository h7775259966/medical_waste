package com.module.entity.collect;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 收集人Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Collect {

    private String collectId;        //收集人id
    private String collectName;        //收集人名称
    private String collectCode;       //收集人条形码
    private String hospitalId;        //所属医院id
    private Date createDate;        //创建时间
    private String remarks;            //备注

}