package com.module.controller.warn.warnType;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnType.WarnType;
import com.common.Request.warn.warnType.WarnTypeRequest;
import com.common.Response.warn.warnType.WarnTypeResult;
import com.module.service.warn.warnType.WarnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预警类型Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnType")
public class WarnTypeController implements WarnTypeControllerApi{

	@Autowired
	private WarnTypeService warnTypeService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnTypeRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnTypeRequest warnTypeRequest) {

		return warnTypeService.findList(page,size, warnTypeRequest);
	}


	/**
	 * 添加预警类型
	 * @param warnType
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnTypeResult add(@RequestBody WarnType warnType) {

		return warnTypeService.add(warnType);
	}

	/**
	 * 通过id查询预警类型
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnTypeResult findById(@PathVariable("id") String id) {

		return warnTypeService.findById(id);
	}

	/**
	 * 通过id修改预警类型
	 * @param id
	 * @param warnType
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnTypeResult edit(@PathVariable("id") String id, @RequestBody WarnType warnType) {

		return warnTypeService.edit(id,warnType);
	}

	/**
	 * 通过id删除预警类型
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnTypeService.delete(id);
	}
}