package com.module.controller.hospital.city;


import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.controller.hospital.city.CityControllerApi;
import com.module.entity.hospital.city.City;
import com.common.Request.hospital.city.CityRequest;
import com.common.Response.hospital.city.CityResult;
import com.module.service.hospital.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 市级单位Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/city")
public class CityController implements CityControllerApi {

	@Autowired
	private CityService cityService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param cityRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, CityRequest cityRequest) {

		return cityService.findList(page,size, cityRequest);
	}


	/**
	 * 查询所有市级单位
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return cityService.all();
	}

	/**
	 * 添加市级单位
	 * @param city
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public CityResult add(@RequestBody City city) {

		return cityService.add(city);
	}

	/**
	 * 通过id查询市级单位
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public CityResult findById(@PathVariable("id") String id) {

		return cityService.findById(id);
	}

	/**
	 * 通过id修改市级单位
	 * @param id
	 * @param city
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public CityResult edit(@PathVariable("id") String id, @RequestBody City city) {

		return cityService.edit(id,city);
	}

	/**
	 * 通过id删除市级单位
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return cityService.delete(id);
	}
	
}