package com.module.controller.hospital.department;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.department.Department;
import com.module.request.hospital.department.DepartmentRequest;
import com.module.response.hospital.department.DepartmentResult;
import com.module.service.hospital.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院部门Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/department")
public class DepartmentController implements DepartmentControllerApi{

	@Autowired
	private DepartmentService departmentService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param departmentRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, DepartmentRequest departmentRequest) {

		return departmentService.findList(page,size, departmentRequest);
	}

	/**
	 * 查询所有部门
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return departmentService.all();
	}

	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public DepartmentResult add(@RequestBody Department department) {

		return departmentService.add(department);
	}

	/**
	 * 通过id查询部门
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public DepartmentResult findById(@PathVariable("id") String id) {

		return departmentService.findById(id);
	}

	/**
	 * 通过id修改部门
	 * @param id
	 * @param department
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public DepartmentResult edit(@PathVariable("id") String id, @RequestBody Department department) {

		return departmentService.edit(id,department);
	}

	/**
	 * 通过id删除部门
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return departmentService.delete(id);
	}
}