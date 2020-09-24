package com.module.entity.trash.trashCollect;

import lombok.Data;

import java.util.Date;

/**
 * 医废收集Entity
 * Created by huangbotao on 2020/8/31;
 */

@Data
public class TrashCollect {

    private String trashCollectId;  //医废收集id   
            private Date createDate; //创建时间   
            private String officeId; //科室ID   
            private String departmentId; //部门ID   
            private String code; // 条形编码   
            private String trashId; //废物类型ID   
            private String Packets;  //医废包数   
            private String collectMethods; //收集方式   
            private String equipmentId;  //设备名称   
            private String collectId;  //移交人员   
            private String collectTime;  //收集时间   
            private String collectNumber;  //回收趟次   
            private String violationWeight;  //物品重量   


}
