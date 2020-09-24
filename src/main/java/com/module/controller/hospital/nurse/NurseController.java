package com.module.controller.hospital.nurse;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.nurse.Nurse;
import com.common.Request.hospital.nurse.NurseRequest;
import com.common.Response.hospital.nurse.NurseResult;
import com.module.service.hospital.nurse.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院护士Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/nurse")
public class NurseController implements NurseControllerApi{

	@Autowired
	private NurseService nurseService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param nurseRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, NurseRequest nurseRequest) {

		return nurseService.findList(page,size, nurseRequest);
	}


	/**
	 * 添加护士
	 * @param nurse
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public NurseResult add(@RequestBody Nurse nurse) {

		return nurseService.add(nurse);
	}

	/**
	 * 通过id查询护士
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public NurseResult findById(@PathVariable("id") String id) {

		return nurseService.findById(id);
	}

	/**
	 * 通过id修改护士
	 * @param id
	 * @param nurse
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public NurseResult edit(@PathVariable("id") String id, @RequestBody Nurse nurse) {

		return nurseService.edit(id,nurse);
	}

	/**
	 * 通过id删除护士
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return nurseService.delete(id);
	}
}