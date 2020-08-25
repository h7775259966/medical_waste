package com.module.service.User;

import com.module.entity.User.User;
import com.module.dao.User.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        System.out.println("111111111进入queryUserList方法:"+users);
        return users;
    }

    public List<User> queryUserList2(){
        List<User> users = userMapper.findList();
        System.out.println("22222222222进入queryUserList2方法:"+users);
        return users;
    }
}