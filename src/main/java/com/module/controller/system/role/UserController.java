package com.module.controller.system.role;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.User;
import com.module.request.system.role.UserAndRoleRequest;
import com.module.request.system.role.UserRequest;
import com.module.response.system.role.UserResult;
import com.module.service.system.role.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 用户Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi{

	@Autowired
	private UserService userService;

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


	/**
	 * 通过id修改用户状态
	 * @param id
	 * @param status
	 * @return
	 */
	@Override
	@PutMapping("/editStatus/{id}/{status}")
	public UserResult editStatus(@PathVariable("id") String id,@PathVariable("status") Integer status) {

		return userService.editStatus(id,status);
	}

	/**
	 * 给用户分配角色
	 * @param userAndRoleRequest
	 * @return
	 */
	@Override
	@PostMapping("/assignRoles")
	public ResponseResult assignRoles(@RequestBody UserAndRoleRequest userAndRoleRequest) {

		return userService.assignRoles(userAndRoleRequest);
	}
}
