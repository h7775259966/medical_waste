package com.module.controller.User;

import com.module.entity.User.User;
import com.module.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi{

    @Autowired
    private UserService userService;

    @Override
    @GetMapping("/queryUserList")
    public List<User> queryUserList(){
        List<User> users = userService.queryUserList();
        return users;
    }

    @Override
    @GetMapping("/queryUserList2")
    public List<User> queryUserList2(){
        List<User> users = userService.queryUserList2();
        return users;
    }
}
