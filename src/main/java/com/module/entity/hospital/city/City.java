package com.module.entity.hospital.city;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 市级单位Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class City {

    private String cityId;        //市级单位id
    private String cityName;        //市级单位名称
    private String cityNumber;      //市级单位编号
    private String provinceId;        //所属省级单位id
    private String area;        //所在地
    private String grade;       //等级 1为省,2为市,3为区县
    private String principal;       //市级单位负责人
    private String longitude;     //经度
    private String latitude;      //纬度
    private Date createDate;        //创建时间
    private String remarks;        //备注

}