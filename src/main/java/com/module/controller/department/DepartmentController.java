package com.module.controller.department;

import com.common.response.QueryResponseResult;
import com.common.response.ResponseResult;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentPageRequest;
import com.module.response.department.DepartmentPageResult;
import com.module.service.department.DepartmentService;
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
	 * @param departmentPageRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, DepartmentPageRequest departmentPageRequest) {

		return departmentService.findList(page,size,departmentPageRequest);
	}


	/**
	 * 添加部门
	 * @param department
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public DepartmentPageResult add(@RequestBody Department department) {

		return departmentService.add(department);
	}

	/**
	 * 通过id查询部门
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public Department findById(@PathVariable("id") String id) {

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
	public DepartmentPageResult edit(@PathVariable("id") String id, @RequestBody Department department) {

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