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
    private String grade;       //医院等级
    private String bedNumber;       //床位数
    private String averageTrash;        //平均医废量/日
    private String officeNumber;        //科室数量
    private String principal;       //医院第一负责人
    private String hospitalContent;     //医院说明
    private String picture;     //上传的图片
    private String processingMode;      //医废处置方式(自行处置:0;集中处置:1)
    private Date createDate;        //创建时间
    private String remarks;        //备注

}