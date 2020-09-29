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
    private int status;             //设备状态,1为离线,2为在线
    private String hospitalId;       //所属医院id
    private String remarks;           //备注
    private Date createDate;        //创建时间

    private String hospitalName;        //医院名称,用于前端展示使用

}
