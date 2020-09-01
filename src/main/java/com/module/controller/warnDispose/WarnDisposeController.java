package com.module.controller.warnDispose;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.controller.warnDispose.WarnDisposeControllerApi;
import com.module.entity.warnDispose.WarnDispose;
import com.module.request.warnDispose.WarnDisposeRequest;
import com.module.response.warnDispose.WarnDisposeResult;
import com.module.service.warnDispose.WarnDisposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预警处理Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnDispose")
public class WarnDisposeController implements WarnDisposeControllerApi{

	@Autowired
	private WarnDisposeService warnDisposeService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnDisposeRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnDisposeRequest warnDisposeRequest) {

		return warnDisposeService.findList(page,size, warnDisposeRequest);
	}


	/**
	 * 添加预警处理
	 * @param warnDispose
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnDisposeResult add(@RequestBody WarnDispose warnDispose) {

		return warnDisposeService.add(warnDispose);
	}

	/**
	 * 通过id查询预警处理
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnDisposeResult findById(@PathVariable("id") String id) {

		return warnDisposeService.findById(id);
	}

	/**
	 * 通过id修改预警处理
	 * @param id
	 * @param warnDispose
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnDisposeResult edit(@PathVariable("id") String id, @RequestBody WarnDispose warnDispose) {

		return warnDisposeService.edit(id,warnDispose);
	}

	/**
	 * 通过id删除预警处理
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnDisposeService.delete(id);
	}
}