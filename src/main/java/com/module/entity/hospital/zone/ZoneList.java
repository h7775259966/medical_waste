package com.module.entity.hospital.zone;

import com.module.entity.hospital.hospital.Hospital;
import com.module.entity.hospital.hospital.HospitalList;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * Created by huangbotao on 2020/9/28;
 */
@Data
@ToString
public class ZoneList {

    private String zoneId;        //区县级单位id
    private String zoneName;        //区县级单位名称
    private String violationWeight; //医废重量
    private String Packets; //医废包数
    private String trashType; //医废类型
    private Date createDate; //创建时间
    private List<HospitalList> hospitalList; //市级单位
}
