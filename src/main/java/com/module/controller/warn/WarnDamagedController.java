package com.module.controller.warn;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.WarnDamaged;
import com.common.Request.warn.warnDamaged.WarnDamagedRequest;
import com.common.Response.warn.warnDamaged.WarnDamagedResult;
import com.module.service.warn.warnDamaged.WarnDamagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 破损预警Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnDamaged")
public class WarnDamagedController implements WarnDamagedControllerApi{

	@Autowired
	private WarnDamagedService warnDamagedService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnDamagedRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnDamagedRequest warnDamagedRequest) {

		return warnDamagedService.findList(page,size, warnDamagedRequest);
	}


	/**
	 * 添加破损预警
	 * @param warnDamaged
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnDamagedResult add(@RequestBody WarnDamaged warnDamaged) {

		return warnDamagedService.add(warnDamaged);
	}

	/**
	 * 通过id查询破损预警
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnDamagedResult findById(@PathVariable("id") String id) {

		return warnDamagedService.findById(id);
	}

	/**
	 * 通过id修改破损预警
	 * @param id
	 * @param warnDamaged
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnDamagedResult edit(@PathVariable("id") String id, @RequestBody WarnDamaged warnDamaged) {

		return warnDamagedService.edit(id,warnDamaged);
	}

	/**
	 * 通过id删除破损预警
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnDamagedService.delete(id);
	}
}