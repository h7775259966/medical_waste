package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnInWeight;
import com.common.Request.warn.WarnInWeightRequest;
import com.common.Response.warn.WarnInWeightResult;
import com.module.service.warn.WarnInWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 入库重量预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnInWeight")
public class WarnInWeightController implements WarnInWeightControllerApi{

	@Autowired
	private WarnInWeightService warnInWeightService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnInWeightRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnInWeightRequest warnInWeightRequest) {

		return warnInWeightService.findList(page,size, warnInWeightRequest);
	}


	/**
	 * 添加入库重量预警
	 * @param warnInWeight
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnInWeightResult add(@RequestBody WarnInWeight warnInWeight) {

		return warnInWeightService.add(warnInWeight);
	}

	/**
	 * 通过id查询入库重量预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnInWeightResult findById(@PathVariable("id") String id) {

		return warnInWeightService.findById(id);
	}

	/**
	 * 通过id修改入库重量预警
	 * @param id
	 * @param warnInWeight
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnInWeightResult edit(@PathVariable("id") String id, @RequestBody WarnInWeight warnInWeight) {

		return warnInWeightService.edit(id,warnInWeight);
	}

	/**
	 * 通过id删除入库重量预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnInWeightService.delete(id);
	}
}