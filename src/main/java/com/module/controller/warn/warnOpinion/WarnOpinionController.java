package com.module.controller.warn.warnOpinion;

import com.common.Request.warn.warnOpinion.WarnOpinionRequest;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.common.Response.warn.warnOpinion.WarnOpinionResult;
import com.module.entity.warn.warnOpinion.WarnOpinion;
import com.module.service.warn.warnOpinion.WarnOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预警意见Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnOpinion")
public class WarnOpinionController implements WarnOpinionControllerApi{

	@Autowired
	private WarnOpinionService warnOpinionService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnOpinionRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnOpinionRequest warnOpinionRequest) {

		return warnOpinionService.findList(page,size, warnOpinionRequest);
	}


	/**
	 * 添加预警意见
	 * @param warnOpinion
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnOpinionResult add(@RequestBody WarnOpinion warnOpinion) {

		return warnOpinionService.add(warnOpinion);
	}

	/**
	 * 通过id查询预警意见
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnOpinionResult findById(@PathVariable("id") String id) {

		return warnOpinionService.findById(id);
	}

	/**
	 * 通过id修改预警意见
	 * @param id
	 * @param warnOpinion
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnOpinionResult edit(@PathVariable("id") String id, @RequestBody WarnOpinion warnOpinion) {

		return warnOpinionService.edit(id,warnOpinion);
	}

	/**
	 * 通过id删除预警意见
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnOpinionService.delete(id);
	}
}