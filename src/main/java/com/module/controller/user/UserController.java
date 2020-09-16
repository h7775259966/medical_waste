package com.module.controller.user;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.user.User;
import com.module.entity.user.User;
import com.module.request.user.UserRequest;
import com.module.response.user.UserResult;
import com.module.response.user.UserResult;
import com.module.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户Controller
 * Created by huangbotao on 2020/9/1;
 */

@RestController
@RequestMapping("/login")
public class UserController implements UserControllerApi{

    @Autowired
    private UserService userService;


    @Override
    @PostMapping("/in")
    public UserResult login(User user) {
        return userService.login(user);
    }

    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param userRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, UserRequest userRequest) {

        return userService.findList(page,size, userRequest);
    }


    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    @PostMapping("/add")
    public UserResult add(@RequestBody User user) {

        return userService.add(user);
    }

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public UserResult findById(@PathVariable("id") String id) {

        return userService.findById(id);
    }

    /**
     * 通过id修改用户
     * @param id
     * @param user
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public UserResult edit(@PathVariable("id") String id, @RequestBody User user) {

        return userService.edit(id,user);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return userService.delete(id);
    }
}
