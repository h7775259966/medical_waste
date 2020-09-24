package com.module.controller.system.dict;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.system.dict.Dict;
import com.common.Request.system.dict.DictRequest;
import com.common.Response.system.dict.DictResult;
import com.module.service.system.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统字典Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/dict")
public class DictController implements DictControllerApi{

	@Autowired
	private DictService dictService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param dictRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, DictRequest dictRequest) {

		return dictService.findList(page,size, dictRequest);
	}


	/**
	 * 添加系统字典
	 * @param dict
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public DictResult add(@RequestBody Dict dict) {

		return dictService.add(dict);
	}

	/**
	 * 通过id查询系统字典
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public DictResult findById(@PathVariable("id") String id) {

		return dictService.findById(id);
	}

	/**
	 * 通过id修改系统字典
	 * @param id
	 * @param dict
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public DictResult edit(@PathVariable("id") String id, @RequestBody Dict dict) {

		return dictService.edit(id,dict);
	}

	/**
	 * 通过id删除系统字典
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return dictService.delete(id);
	}

	/**
	 * 通过字典api查询所有字典数据
	 * @param dictApi
	 * @return
	 */
	@Override
	@GetMapping("/findByDictApi/{dictApi}")
	public QueryResponseResult findByDictApi(@PathVariable("dictApi") String dictApi) {

		return dictService.findByDictApi(dictApi);
	}
}