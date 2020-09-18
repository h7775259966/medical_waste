package com.module.entity.system.role;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 用户Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class User{

    private String id;      //主键
    private String username;        //用户名
    private String password;        //登录密码
    private Integer enableState;        //启用状态 0为禁用 1为启用
    private String mobile;          //手机号码
    private String email;          //邮箱地址d
    private String nickname;        //昵称
    private String hospitalId;       //所属医院id
    private String remark;      //备注
    private Date createDate;		//创建时间

}
