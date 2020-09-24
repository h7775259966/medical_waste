package com.module.entity.hospital.zone;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 区县级单位Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Zone {

    private String zoneId;        //区县级单位id
    private String zoneName;        //区县级单位名称
    private String zoneNumber;      //区县级单位编号
    private String provinceId;        //所属省级单位id
    private String cityId;        //所属市级单位id
    private String area;        //所在地
    private String grade;       //等级(省区县区医院)
    private String principal;       //区县级单位负责人
    private String longitude;     //经度
    private String latitude;      //纬度
    private Date createDate;        //创建时间
    private String remarks;        //备注

}