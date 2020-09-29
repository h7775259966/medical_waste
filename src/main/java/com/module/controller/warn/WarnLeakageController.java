package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnLeakage;
import com.common.Request.warn.warnLeakage.WarnLeakageRequest;
import com.common.Response.warn.warnLeakage.WarnLeakageResult;
import com.module.service.warn.warnLeakage.WarnLeakageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 遗失预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnLeakage")
public class WarnLeakageController implements WarnLeakageControllerApi{

	@Autowired
	private WarnLeakageService warnLeakageService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnLeakageRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnLeakageRequest warnLeakageRequest) {

		return warnLeakageService.findList(page,size, warnLeakageRequest);
	}


	/**
	 * 添加遗失预警
	 * @param warnLeakage
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnLeakageResult add(@RequestBody WarnLeakage warnLeakage) {

		return warnLeakageService.add(warnLeakage);
	}

	/**
	 * 通过id查询遗失预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnLeakageResult findById(@PathVariable("id") String id) {

		return warnLeakageService.findById(id);
	}

	/**
	 * 通过id修改遗失预警
	 * @param id
	 * @param warnLeakage
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnLeakageResult edit(@PathVariable("id") String id, @RequestBody WarnLeakage warnLeakage) {

		return warnLeakageService.edit(id,warnLeakage);
	}

	/**
	 * 通过id删除遗失预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnLeakageService.delete(id);
	}
}