package com.module.controller.hospital.office;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.office.Office;
import com.common.Request.hospital.office.OfficeRequest;
import com.common.Response.hospital.office.OfficeResult;
import com.module.service.hospital.office.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院科室Controller
 * @author zx
 * @version 2020-08-26
 */
@RestController
@RequestMapping("/office")
public class OfficeController implements OfficeControllerApi{

	@Autowired
	private OfficeService officeService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param officeRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, OfficeRequest officeRequest) {

		return officeService.findList(page,size, officeRequest);
	}

	/**
	 * 查询所有科室
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return officeService.all();
	}

	/**
	 * 添加科室
	 * @param office
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public OfficeResult add(@RequestBody Office office) {

		return officeService.add(office);
	}

	/**
	 * 通过id查询科室
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public OfficeResult findById(@PathVariable("id") String id) {

		return officeService.findById(id);
	}

	/**
	 * 通过id修改科室
	 * @param id
	 * @param office
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public OfficeResult edit(@PathVariable("id") String id, @RequestBody Office office) {

		return officeService.edit(id,office);
	}

	/**
	 * 通过id删除科室
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return officeService.delete(id);
	}

	/**
	 * 通过部门id查询所属科室
	 * @param departmentId
	 * @return
	 */
	@Override
	@GetMapping("/findByDepartmentId/{departmentId}")
	public QueryResponseResult findByDepartmentId(@PathVariable("departmentId") String departmentId) {

		return officeService.findByDepartmentId(departmentId);
	}
}