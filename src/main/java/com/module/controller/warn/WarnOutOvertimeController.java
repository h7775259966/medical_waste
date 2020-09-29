package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnOutOvertime;
import com.common.Request.warn.WarnOutOvertimeRequest;
import com.common.Response.warn.WarnOutOvertimeResult;
import com.module.service.warn.WarnOutOvertimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 出库超时预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnOutOvertime")
public class WarnOutOvertimeController implements WarnOutOvertimeControllerApi{

	@Autowired
	private WarnOutOvertimeService warnOutOvertimeService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnOutOvertimeRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnOutOvertimeRequest warnOutOvertimeRequest) {

		return warnOutOvertimeService.findList(page,size, warnOutOvertimeRequest);
	}


	/**
	 * 添加出库超时预警
	 * @param warnOutOvertime
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnOutOvertimeResult add(@RequestBody WarnOutOvertime warnOutOvertime) {

		return warnOutOvertimeService.add(warnOutOvertime);
	}

	/**
	 * 通过id查询出库超时预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnOutOvertimeResult findById(@PathVariable("id") String id) {

		return warnOutOvertimeService.findById(id);
	}

	/**
	 * 通过id修改出库超时预警
	 * @param id
	 * @param warnOutOvertime
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnOutOvertimeResult edit(@PathVariable("id") String id, @RequestBody WarnOutOvertime warnOutOvertime) {

		return warnOutOvertimeService.edit(id,warnOutOvertime);
	}

	/**
	 * 通过id删除出库超时预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnOutOvertimeService.delete(id);
	}
}