package com.module.entity.system.role;

import com.module.entity.system.permission.PermissionAll;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 角色Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class Role {

    private String id;      //主键
    private String roleName;            //角色名
    private String unitId;       //所属单位id
    private String grade;       //所属单位级别(省市区医院)
    private String remarks;		//备注
    private Date createDate;		//创建时间

    private List<PermissionAll> permissionAllList;      //此角色下所分配的所有权限，用于给前端展示
}