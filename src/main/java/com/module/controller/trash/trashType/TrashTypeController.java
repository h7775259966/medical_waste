package com.module.controller.trash.trashType;

import com.common.Response.ResponseResult;
import com.module.entity.trash.trashType.TrashType;
import com.common.Response.trash.trashType.TrashTypeResult;
import com.module.service.trash.trashType.TrashTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院医废类型Controller
 * @author zx
 * @version 2020-08-26
 */
@RestController
@RequestMapping("/trashType")
public class TrashTypeController implements TrashTypeControllerApi{

	@Autowired
	private TrashTypeService trashTypeService;

	/**
	 * 添加医废类型
	 * @param trashType
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public TrashTypeResult add(@RequestBody TrashType trashType) {

		return trashTypeService.add(trashType);
	}

	/**
	 * 通过id查询医废类型
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public TrashTypeResult findById(@PathVariable("id") String id) {

		return trashTypeService.findById(id);
	}

	/**
	 * 通过id修改医废类型
	 * @param id
	 * @param trashType
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public TrashTypeResult edit(@PathVariable("id") String id, @RequestBody TrashType trashType) {

		return trashTypeService.edit(id,trashType);
	}

	/**
	 * 通过id删除医废类型
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return trashTypeService.delete(id);
	}
}