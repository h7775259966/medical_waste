package com.module.entity.equipment;

import lombok.Data;
import lombok.ToString;


/**
 * 设备Entity
 * @author huangbotao
 * @version 2020-09-03
 */


import java.util.Date;

@Data
@ToString
public class Equipment {

    private String equipmentId;    //设备ID
    private String equipmentName;   //设备名称
    private String equipmentNum;   //设备编号
    private String equipmentSIM;   //设备SIM卡号
    private String equipmentFirm;   //设备生产商
    private int status;  //设备状态
    private String remarks; //设备备
    private Date createDate;  //创建时间

}
