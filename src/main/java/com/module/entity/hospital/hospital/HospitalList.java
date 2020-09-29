package com.module.entity.hospital.hospital;

import com.module.entity.trash.trashCollect.TrashCollect;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 区级单位关联医废收集级查询表
 * Created by huangbotao on 2020/9/28;
 */

@Data
@ToString
public class HospitalList {

    private String hospitalId;        // 医院id
    private String hospitalName;        //医院名称
    private String violationWeight; //医废重量
    private String Packets; //医废包数
    private String trashType; //医废类型
    private Date createDate; //创建时间
    private List<TrashCollect> trashCollectList; //医废收集ID关联
}
