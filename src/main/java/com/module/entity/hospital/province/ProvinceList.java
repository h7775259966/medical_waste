package com.module.entity.hospital.province;

import com.module.entity.hospital.city.CityList;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 省级单位关联市级单位查询表
 * Created by huangbotao on 2020/9/28;
 */
@Data
@ToString
public class ProvinceList {


    private String provinceId;        //省级单位id
    private String provinceName;        //省级单位名称
    private String violationWeight; //医废重量
    private String Packets; //医废包数
    private String trashType; //医废类型
    private Date createDate; //创建时间
    private List<CityList>  cityList; //市级单位

}
