package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnLose;
import com.common.Request.warn.warnLose.WarnLoseRequest;
import com.common.Response.warn.warnLose.WarnLoseResult;
import com.module.service.warn.warnLose.WarnLoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 遗失预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnLose")
public class WarnLoseController implements WarnLoseControllerApi{

	@Autowired
	private WarnLoseService warnLoseService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnLoseRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnLoseRequest warnLoseRequest) {

		return warnLoseService.findList(page,size, warnLoseRequest);
	}


	/**
	 * 添加遗失预警
	 * @param warnLose
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnLoseResult add(@RequestBody WarnLose warnLose) {

		return warnLoseService.add(warnLose);
	}

	/**
	 * 通过id查询遗失预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnLoseResult findById(@PathVariable("id") String id) {

		return warnLoseService.findById(id);
	}

	/**
	 * 通过id修改遗失预警
	 * @param id
	 * @param warnLose
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnLoseResult edit(@PathVariable("id") String id, @RequestBody WarnLose warnLose) {

		return warnLoseService.edit(id,warnLose);
	}

	/**
	 * 通过id删除遗失预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnLoseService.delete(id);
	}
}