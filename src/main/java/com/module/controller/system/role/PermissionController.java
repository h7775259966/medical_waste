package com.module.controller.system.role;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.role.PermissionAll;
import com.common.Request.system.role.PermissionRequest;
import com.common.Response.system.role.PermissionResult;
import com.module.service.system.role.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 权限Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/permission")
public class PermissionController implements PermissionControllerApi {

	@Autowired
	private PermissionService permissionService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param permissionRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, PermissionRequest permissionRequest) {

		return permissionService.findList(page,size, permissionRequest);
	}


	/**
	 * 查询所有权限
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return permissionService.all();
	}

	/**
	 * 添加权限
	 * @param permissionAll
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public PermissionResult add(@RequestBody PermissionAll permissionAll) {

		return permissionService.add(permissionAll);
	}

	/**
	 * 通过id查询权限
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public PermissionResult findById(@PathVariable("id") String id) {

		return permissionService.findById(id);
	}

	/**
	 * 通过id修改权限
	 * @param id
	 * @param permissionAll
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public PermissionResult edit(@PathVariable("id") String id, @RequestBody PermissionAll permissionAll) {

		return permissionService.edit(id,permissionAll);
	}

	/**
	 * 通过id删除权限
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return permissionService.delete(id);
	}

}