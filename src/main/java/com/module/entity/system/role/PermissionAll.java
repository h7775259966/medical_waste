package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 权限(含有菜单，按钮功能，API接口)Entity
 * 封装前端数据的权限集合对象
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class PermissionAll {

    //Permission
    private String id;           //全部共用一个权限id
    private String name;             //权限名称
    private Integer type;            //权限类型 1为菜单 2为按钮功能 3为API
    private String code;             //标识
    private String pid;             //父级id
    private Integer enVisible;      //可见状态:是否查询全部权限(0:全部权限;1:只查询企业所属权限) 
    private String remarks;		//备注
    private Date createDate;		//创建时间

    //PermissionApi
    private String apiUrl;      //链接
    private String apiMethod;       //请求类型
    private String apiLevel;        //权限等级，1为通用接口权限，2为需校验接口权限

    //PermissionMenu
    private String menuIcon;        //展示图标
    private String menuOrder;       //排序号

    //PermissionPoint
    private String pointClass;      //按钮代码
    private String pointIcon;       //按钮图标
    private String pointStatus;     //按钮状态

}