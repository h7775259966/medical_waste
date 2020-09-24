package com.module.controller.warn.warnRecord;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.warn.warnRecord.WarnRecord;
import com.common.Request.warn.warnRecord.WarnRecordRequest;
import com.common.Response.warn.warnRecord.WarnRecordResult;
import com.module.service.warn.warnRecord.WarnRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 预警记录Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/warnRecord")
public class WarnRecordController implements WarnRecordControllerApi{

	@Autowired
	private WarnRecordService warnRecordService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param warnRecordRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, WarnRecordRequest warnRecordRequest) {

		return warnRecordService.findList(page,size, warnRecordRequest);
	}


	/**
	 * 添加预警记录
	 * @param warnRecord
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public WarnRecordResult add(@RequestBody WarnRecord warnRecord) {

		return warnRecordService.add(warnRecord);
	}

	/**
	 * 通过id查询预警记录
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public WarnRecordResult findById(@PathVariable("id") String id) {

		return warnRecordService.findById(id);
	}

	/**
	 * 通过id修改预警记录
	 * @param id
	 * @param warnRecord
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public WarnRecordResult edit(@PathVariable("id") String id, @RequestBody WarnRecord warnRecord) {

		return warnRecordService.edit(id,warnRecord);
	}

	/**
	 * 通过id删除预警记录
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return warnRecordService.delete(id);
	}
}