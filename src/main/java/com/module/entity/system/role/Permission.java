package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 权限(含有菜单，按钮功能，API接口)Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class Permission{

    private String id;           //主键
    private String name;             //权限名称
    private Integer type;            //权限类型 1为菜单 2为按钮功能 3为API
    private String code;             //标识
    private String description;     //权限描述
    private String pid;             //父级id
    private Date createDate;		//创建时间
    private Integer enVisible;

    public Permission(String name, Integer type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }

}