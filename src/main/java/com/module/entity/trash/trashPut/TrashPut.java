package com.module.entity.trash.trashPut;

import lombok.Data;

import java.util.Date;

/**
 * 医废入库Entity
 * Created by huangbotao on 2020/8/31;
 */
@Data
public class TrashPut {

    private String trashPutId; //医废收集id
    private Date createDate; //创建时间
    private String officeId; //科室ID
    private String departmentId; //部门ID
    private String code; //条形编码
    private String trashId; //废物类型ID
    private String Packets; //医废包数
    private String recycle;  //回收人员
    private String collectId; //移交人员
    private Date collectTime; //收集时间
    private String collectNumber;//回收趟次
    private String caseNum;//转运箱编号
    private String weight;//物品重量
    private String weightNumber; //物品称重
    private Date putInTime;//入库时间
    private String collectMethods;//收集方式
    private String officeName;     //科室名称officeName字段仅在前端展示数据时使用
    private String trashType;     //医废类型trashType字段仅在前端展示数据时使用
}
