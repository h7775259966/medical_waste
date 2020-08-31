package com.module.controller.hospital;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.Hospital;
import com.module.request.hospital.HospitalRequest;
import com.module.response.hospital.HospitalResult;
import com.module.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/hospital")
public class HospitalController implements HospitalControllerApi{

	@Autowired
	private HospitalService hospitalService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param hospitalRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, HospitalRequest hospitalRequest) {

		return hospitalService.findList(page,size, hospitalRequest);
	}


	/**
	 * 查询所有医院
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return hospitalService.all();
	}

	/**
	 * 添加医院
	 * @param hospital
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public HospitalResult add(@RequestBody Hospital hospital) {

		return hospitalService.add(hospital);
	}

	/**
	 * 通过id查询医院
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public HospitalResult findById(@PathVariable("id") String id) {

		return hospitalService.findById(id);
	}

	/**
	 * 通过id修改医院
	 * @param id
	 * @param hospital
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public HospitalResult edit(@PathVariable("id") String id, @RequestBody Hospital hospital) {

		return hospitalService.edit(id,hospital);
	}

	/**
	 * 通过id删除医院
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return hospitalService.delete(id);
	}
}