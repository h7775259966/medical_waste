package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 菜单权限Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class PermissionMenu{

    private String id;      // 主键
    private String menuIcon;        //展示图标
    private String menuOrder;       //排序号
    private Date createDate;		//创建时间
}