package com.module.entity.system.user;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 给用户分配角色(中间表)Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class UserAndRole {

    private String id;      //主键
    private String userId;            //用户id
    private String roleId;       //角色id
    private Date createDate;		//创建时间

}