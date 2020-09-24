package com.module.controller.warn.warnViolation;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnViolation.WarnViolation;
import com.common.Request.warn.warnViolation.WarnViolationRequest;
import com.common.Response.warn.warnViolation.WarnViolationResult;
import com.module.service.warn.warnViolation.WarnViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 违规预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnViolation")
public class WarnViolationController implements WarnViolationControllerApi{

	@Autowired
	private WarnViolationService warnViolationService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnViolationRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnViolationRequest warnViolationRequest) {

		return warnViolationService.findList(page,size, warnViolationRequest);
	}


	/**
	 * 添加违规预警
	 * @param warnViolation
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnViolationResult add(@RequestBody WarnViolation warnViolation) {

		return warnViolationService.add(warnViolation);
	}

	/**
	 * 通过id查询违规预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnViolationResult findById(@PathVariable("id") String id) {

		return warnViolationService.findById(id);
	}

	/**
	 * 通过id修改违规预警
	 * @param id
	 * @param warnViolation
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnViolationResult edit(@PathVariable("id") String id, @RequestBody WarnViolation warnViolation) {

		return warnViolationService.edit(id,warnViolation);
	}

	/**
	 * 通过id删除违规预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnViolationService.delete(id);
	}
}