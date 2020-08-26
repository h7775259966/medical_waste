package com.module.controller.collect;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.collect.Collect;
import com.module.request.collect.CollectRequest;
import com.module.response.collect.CollectResult;
import com.module.service.collect.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收集人Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/collect")
public class CollectController implements CollectControllerApi{

	@Autowired
	private CollectService collectService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param collectRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, CollectRequest collectRequest) {

		return collectService.findList(page,size, collectRequest);
	}


	/**
	 * 添加收集人
	 * @param collect
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public CollectResult add(@RequestBody Collect collect) {

		return collectService.add(collect);
	}

	/**
	 * 通过id查询收集人
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public CollectResult findById(@PathVariable("id") String id) {

		return collectService.findById(id);
	}

	/**
	 * 通过id修改收集人
	 * @param id
	 * @param collect
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public CollectResult edit(@PathVariable("id") String id, @RequestBody Collect collect) {

		return collectService.edit(id,collect);
	}

	/**
	 * 通过id删除收集人
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return collectService.delete(id);
	}
}