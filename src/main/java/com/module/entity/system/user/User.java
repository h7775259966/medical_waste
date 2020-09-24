package com.module.entity.system.user;

import com.module.entity.system.role.Role;
import lombok.Data;
import lombok.ToString;
import java.util.Date;
import java.util.List;

/**
 * 用户Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class User{

    private String id;      //主键
    private String userName;        //用户名
    private String passWord;        //登录密码
    private Integer status;        //启用状态 0为禁用 1为启用
    private String mobile;          //手机号码
    private String email;          //邮箱地址d
    private String nickName;        //昵称
    private String unitId;       //所属单位id
    private String grade;       //所属单位级别(省市区医院)
    private String remarks;      //备注
    private Date createDate;	//创建时间

    private List<Role> roleList;    //此用户下所分配的所有角色，用于给前端展示

}
