package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 给角色分配权限(中间表)Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class RoleAndPermission {

    private String id;      //主键
    private String roleId;            //角色id
    private String permissionId;       //权限id
    private Date createDate;		//创建时间

}