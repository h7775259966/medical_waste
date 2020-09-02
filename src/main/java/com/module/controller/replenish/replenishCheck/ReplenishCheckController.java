package com.module.controller.replenish.replenishCheck;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.replenish.replenishCheck.ReplenishCheck;
import com.module.request.replenish.replenishCheck.ReplenishCheckRequest;
import com.module.response.replenish.replenishCheck.ReplenishCheckResult;
import com.module.service.replenish.replenishCheck.ReplenishCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医废补录审核Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/replenishCheck")
public class ReplenishCheckController implements ReplenishCheckControllerApi {

	@Autowired
	private ReplenishCheckService replenishCheckService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param replenishCheckRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ReplenishCheckRequest replenishCheckRequest) {

		return replenishCheckService.findList(page,size, replenishCheckRequest);
	}


	/**
	 * 添加医废补录审核
	 * @param replenishCheck
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public ReplenishCheckResult add(@RequestBody ReplenishCheck replenishCheck) {

		return replenishCheckService.add(replenishCheck);
	}

	/**
	 * 通过id查询医废补录审核
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public ReplenishCheckResult findById(@PathVariable("id") String id) {

		return replenishCheckService.findById(id);
	}

	/**
	 * 通过id修改医废补录审核
	 * @param id
	 * @param replenishCheck
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public ReplenishCheckResult edit(@PathVariable("id") String id, @RequestBody ReplenishCheck replenishCheck) {

		return replenishCheckService.edit(id,replenishCheck);
	}

	/**
	 * 通过id删除医废补录审核
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return replenishCheckService.delete(id);
	}
}