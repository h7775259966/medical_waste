package com.module.entity.hospital.province;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 省级单位Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Province {

    private String provinceId;        //省级单位id
    private String provinceName;        //省级单位名称
    private String provinceNumber;      //省级单位编号
    private String area;        //所在地
    private String grade;       //等级(省市区医院)
    private String principal;       //省级单位负责人
    private String longitude;     //经度
    private String latitude;      //纬度
    private Date createDate;        //创建时间
    private String remarks;        //备注

}