package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 按钮权限Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class PermissionPoint{

    private String id;      //主键
    private String pointClass;      //权限代码
    private String pointIcon;       //按钮图标
    private String pointStatus;     //按钮状态
    private Date createDate;		//创建时间

}