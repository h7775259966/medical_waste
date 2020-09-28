package com.module.entity.hospital.hospital;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医院Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class Hospital {

    private String hospitalId;        // 医院id
    private String hospitalName;        //医院名称
    private String hospitalNumber;      //医院编号
    private int grade;       //医院等级
    private int bedNumber;       //床位数
    private String averageTrash;        //平均医废量/日
    private int officeNumber;        //科室数量
    private String principal;       //医院第一负责人
    private String hospitalContent;     //医院说明
    private String picture;     //上传的图片
    private int processingMode;      //医废处置方式:1为自行处置,2为集中处置
    private Date createDate;        //创建时间
    private String remarks;        //备注
    //2020.9.25新增字段
    private int regime;         //医院体制:1为公立,2为民营
    private String supervisionId;       //所属监督单位id
    private int supervisionGrade;       //所属监督单位级别
    private String provinceId;        //所属省级单位id
    private String cityId;        //所属市级单位id
    private String zoneId;        //所属区县级单位id
}