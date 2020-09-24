package com.module.controller.warn.warnNoOut;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnNoOut.WarnNoOut;
import com.common.Request.warn.warnNoOut.WarnNoOutRequest;
import com.common.Response.warn.warnNoOut.WarnNoOutResult;
import com.module.service.warn.warnNoOut.WarnNoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 未出预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnNoOut")
public class WarnNoOutController implements WarnNoOutControllerApi{

	@Autowired
	private WarnNoOutService warnNoOutService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnNoOutRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnNoOutRequest warnNoOutRequest) {

		return warnNoOutService.findList(page,size, warnNoOutRequest);
	}


	/**
	 * 添加未出预警
	 * @param warnNoOut
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnNoOutResult add(@RequestBody WarnNoOut warnNoOut) {

		return warnNoOutService.add(warnNoOut);
	}

	/**
	 * 通过id查询未出预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnNoOutResult findById(@PathVariable("id") String id) {

		return warnNoOutService.findById(id);
	}

	/**
	 * 通过id修改未出预警
	 * @param id
	 * @param warnNoOut
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnNoOutResult edit(@PathVariable("id") String id, @RequestBody WarnNoOut warnNoOut) {

		return warnNoOutService.edit(id,warnNoOut);
	}

	/**
	 * 通过id删除未出预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnNoOutService.delete(id);
	}
}