package com.module.controller.warn.warnPush;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnPush.WarnPush;
import com.module.request.warn.warnPush.WarnPushRequest;
import com.module.response.warn.warnPush.WarnPushResult;
import com.module.service.warn.warnPush.WarnPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预警推送Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnPush")
public class WarnPushController implements WarnPushControllerApi{

	@Autowired
	private WarnPushService warnPushService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnPushRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnPushRequest warnPushRequest) {

		return warnPushService.findList(page,size, warnPushRequest);
	}


	/**
	 * 添加预警推送
	 * @param warnPush
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnPushResult add(@RequestBody WarnPush warnPush) {

		return warnPushService.add(warnPush);
	}

	/**
	 * 通过id查询预警推送
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnPushResult findById(@PathVariable("id") String id) {

		return warnPushService.findById(id);
	}

	/**
	 * 通过id修改预警推送
	 * @param id
	 * @param warnPush
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnPushResult edit(@PathVariable("id") String id, @RequestBody WarnPush warnPush) {

		return warnPushService.edit(id,warnPush);
	}

	/**
	 * 通过id删除预警推送
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnPushService.delete(id);
	}
}