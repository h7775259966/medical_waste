package com.module.controller.system.user;

import com.common.Response.MapResult;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.system.user.UserCode;
import com.common.Utils.JwtUtils;
import com.module.entity.system.user.User;
import com.common.Request.system.user.LoginRequest;
import com.common.Request.system.user.UserAndRoleRequest;
import com.common.Request.system.user.UserRequest;
import com.common.Response.system.user.LoginResult;
import com.common.Response.system.user.UserResult;
import com.module.service.system.user.UserService;
import io.jsonwebtoken.Claims;
import org.omg.SendingContext.RunTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 用户Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

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
	 * (同时查询出此用户下分配的角色)
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping(value="/get/{id}",name="api-user-get")
	public MapResult findById(@PathVariable("id") String id) {

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
	 * 登录成功之后，根据token获取用户信息和所有权限标识
	 * 要求token存储在请求头内(Authorization:Bearer+“ ”+token)
	 * @param request
	 * @return
	 */
	@Override
	@PostMapping(value="/profile")
	public MapResult profile(HttpServletRequest request){
		String authorization = request.getHeader("Authorization");
		if(!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")) {
			String token = authorization.replace("Bearer ","");
			Claims claims = jwtUtils.parseJwt(token);
			if(claims != null) {
				Map<String, Object> map= userService.profile(claims.getId());
				return new MapResult(UserCode.CMS_PRFILE_TRUE,map);
			}
		}
		return new MapResult(UserCode.CMS_PRFILE_FALSE, null);
	}
}
