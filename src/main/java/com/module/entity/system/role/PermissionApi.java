package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * API权限Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class PermissionApi{

    private String id;      //主键
    private String apiUrl;      //链接
    private String apiMethod;       //请求类型
    private String apiLevel;        //权限等级，1为通用接口权限，2为需校验接口权限
    private Date createDate;		//创建时间
}