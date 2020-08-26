package com.module.entity.equipment;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Equipment {

    private String equipmentName;   //设备名称
    private String equipmentId;    //设备ID
    private Integer equipmentNum;   //设备编号
    private Integer equipmentSIM;   //设备SIM卡号
    private String equipmentFirm;   //设备生产商
    private String equipmentRemark; //设备备注
    private String equipmentStatus;  //设备状态
    private Date createDate;  //创建时间

}
