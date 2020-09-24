package com.module.controller.replenish.replenish;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.replenish.replenish.Replenish;
import com.common.Request.replenish.replenish.ReplenishRequest;
import com.common.Response.replenish.replenish.ReplenishResult;
import com.module.service.replenish.replenish.ReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医废补录Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/replenish")
public class ReplenishController implements ReplenishControllerApi{

	@Autowired
	private ReplenishService replenishService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param replenishRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ReplenishRequest replenishRequest) {

		return replenishService.findList(page,size, replenishRequest);
	}


	/**
	 * 添加医废补录
	 * @param replenish
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public ReplenishResult add(@RequestBody Replenish replenish) {

		return replenishService.add(replenish);
	}

	/**
	 * 通过id查询医废补录
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public ReplenishResult findById(@PathVariable("id") String id) {

		return replenishService.findById(id);
	}

	/**
	 * 通过id修改医废补录
	 * @param id
	 * @param replenish
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public ReplenishResult edit(@PathVariable("id") String id, @RequestBody Replenish replenish) {

		return replenishService.edit(id,replenish);
	}

	/**
	 * 通过id删除医废补录
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return replenishService.delete(id);
	}
}