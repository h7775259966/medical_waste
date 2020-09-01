package com.module.entity.user;

import lombok.Data;

import java.util.Date;

/**
 * Created by huangbotao on 2020/9/1;
 */
@Data
public class User {

    private String userId; //用户id
    private Date createDate; //创建时间
    private String userName; //用户名
    private String password; //用户密码
    private String userJurisdiction;  //用户权限
    private String remark;  //备注



}
