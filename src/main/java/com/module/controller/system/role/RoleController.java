package com.module.controller.system.role;

import com.common.Response.MapResult;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.Role;
import com.common.Request.system.role.RoleAndPermissionRequest;
import com.common.Request.system.role.RoleRequest;
import com.common.Response.system.role.RoleResult;
import com.module.service.system.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 角色Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/role")
public class RoleController implements RoleControllerApi{

	@Autowired
	private RoleService roleService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param roleRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, RoleRequest roleRequest) {

		return roleService.findList(page,size, roleRequest);
	}

	/**
	 * 查询所有角色
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return roleService.all();
	}

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public RoleResult add(@RequestBody Role role) {

		return roleService.add(role);
	}

	/**
	 * 通过id查询角色
	 * (同时查询出此角色下分配的权限)
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public MapResult findById(@PathVariable("id") String id) {

		return roleService.findById(id);
	}

	/**
	 * 通过id修改角色
	 * @param id
	 * @param role
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public RoleResult edit(@PathVariable("id") String id, @RequestBody Role role) {

		return roleService.edit(id,role);
	}

	/**
	 * 通过id删除角色
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return roleService.delete(id);
	}

	/**
	 * 给角色分配权限
	 * @param roleAndPermissionRequest
	 * @return
	 */
	@Override
	@PostMapping("/assignPrem")
	public ResponseResult assignPrem(@RequestBody RoleAndPermissionRequest roleAndPermissionRequest) {

		return roleService.assignPrem(roleAndPermissionRequest);
	}
}