package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnOutWeight;
import com.common.Request.warn.warnOutWeight.WarnOutWeightRequest;
import com.common.Response.warn.warnOutWeight.WarnOutWeightResult;
import com.module.service.warn.warnOutWeight.WarnOutWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 出库重量预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnOutWeight")
public class WarnOutWeightController implements WarnOutWeightControllerApi{

	@Autowired
	private WarnOutWeightService warnOutWeightService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnOutWeightRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnOutWeightRequest warnOutWeightRequest) {

		return warnOutWeightService.findList(page,size, warnOutWeightRequest);
	}


	/**
	 * 添加出库重量预警
	 * @param warnOutWeight
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnOutWeightResult add(@RequestBody WarnOutWeight warnOutWeight) {

		return warnOutWeightService.add(warnOutWeight);
	}

	/**
	 * 通过id查询出库重量预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnOutWeightResult findById(@PathVariable("id") String id) {

		return warnOutWeightService.findById(id);
	}

	/**
	 * 通过id修改出库重量预警
	 * @param id
	 * @param warnOutWeight
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnOutWeightResult edit(@PathVariable("id") String id, @RequestBody WarnOutWeight warnOutWeight) {

		return warnOutWeightService.edit(id,warnOutWeight);
	}

	/**
	 * 通过id删除出库重量预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnOutWeightService.delete(id);
	}
}