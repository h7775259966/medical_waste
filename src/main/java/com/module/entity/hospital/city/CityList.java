package com.module.entity.hospital.city;

import com.module.entity.hospital.zone.ZoneList;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 市级单位关联区级单位查询表
 * Created by huangbotao on 2020/9/28;
 */

@Data
@ToString
public class CityList {

    private String cityId;        //市级单位id
    private String cityName;        //市级单位名称
    private String violationWeight; //医废重量
    private String Packets; //医废包数
    private String trashType; //医废类型
    private Date createDate; //创建时间
    private List<ZoneList> zoneList; //市级单位
}
