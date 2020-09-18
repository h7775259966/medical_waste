package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 角色Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class Role {

    private String id;      //主键
    private String name;            //角色名
    private String hospitalId;       //所属医院的id
    private String remarks;		//备注
    private Date createDate;		//创建时间

}