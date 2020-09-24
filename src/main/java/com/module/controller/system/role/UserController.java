package com.module.controller.system.role;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.User;
import com.common.Request.system.role.LoginRequest;
import com.common.Request.system.role.UserAndRoleRequest;
import com.common.Request.system.role.UserRequest;
import com.common.Response.system.role.LoginResult;
import com.common.Response.system.role.UserResult;
import com.module.service.system.role.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping(value="/list/{page}/{size}",name="api-user-list")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, UserRequest userRequest) {

		return userService.findList(page,size, userRequest);
	}


	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@Override
	@PostMapping(value="/add",name="api-user-add")
	public UserResult add(@RequestBody User user) {

		return userService.add(user);
	}

	/**
	 * 通过id查询用户
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping(value="/get/{id}",name="api-user-get")
	public UserResult findById(@PathVariable("id") String id) {

		return userService.findById(id);
	}

	/**
	 * 通过id修改用户
	 * (安全考虑，用户名和状态无法修改)
	 * @param id
	 * @param user
	 * @return
	 */
	@Override
	@PutMapping(value="/edit/{id}",name="api-user-edit")
	public UserResult edit(@PathVariable("id") String id, @RequestBody User user) {

		return userService.edit(id,user);
	}

	/**
	 * 通过id删除用户
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping(value="/del/{id}",name="api-user-del")
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
	@PutMapping(value="/editStatus/{id}/{status}",name="api-user-editStatus")
	public UserResult editStatus(@PathVariable("id") String id,@PathVariable("status") Integer status) {

		return userService.editStatus(id,status);
	}

	/**
	 * 给用户分配角色
	 * @param userAndRoleRequest
	 * @return
	 */
	@Override
	@PostMapping(value="/assignRoles",name="api-user-assignRoles")
	public ResponseResult assignRoles(@RequestBody UserAndRoleRequest userAndRoleRequest) {

		return userService.assignRoles(userAndRoleRequest);
	}

	/**
	 * 用户登录
	 * 认证后返回token
	 * @param loginRequest
	 * @return
	 */
	@Override
	@PostMapping(value="/login")
	public LoginResult login(@RequestBody LoginRequest loginRequest) {

		return userService.login(loginRequest);
	}

	/**
	 * 用户登录成功之后，获取用户信息
	 *      1.获取用户id
	 *      2.根据用户id查询用户
	 *      3.构建返回值对象
	 *      4.响应
	 */
//	@RequestMapping(value="/profile",method = RequestMethod.POST)
//	public Result profile(HttpServletRequest Request) throws Exception {
//
//		String userid = claims.getId();
//		//获取用户信息
//		User user = userService.findById(userid);
//		//根据不同的用户级别获取用户权限
//
//		ProfileResult result = null;
//
//		if("user".equals(user.getLevel())) {
//			result = new ProfileResult(user);
//		}else {
//			Map map = new HashMap();
//			if("coAdmin".equals(user.getLevel())) {
//				map.put("enVisible","1");
//			}
//			List<Permission> list = permissionService.findAll(map);
//			result = new ProfileResult(user,list);
//		}
//		return new Result(ResultCode.SUCCESS,result);
//	}
}
