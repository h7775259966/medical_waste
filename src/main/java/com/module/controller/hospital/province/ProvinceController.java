package com.module.controller.hospital.province;


import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.province.Province;
import com.common.Request.hospital.province.ProvinceRequest;
import com.common.Response.hospital.province.ProvinceResult;
import com.module.service.hospital.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 省级单位Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/province")
public class ProvinceController implements ProvinceControllerApi {

	@Autowired
	private ProvinceService provinceService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param provinceRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ProvinceRequest provinceRequest) {

		return provinceService.findList(page,size, provinceRequest);
	}


	/**
	 * 查询所有省级单位
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return provinceService.all();
	}

	/**
	 * 添加省级单位
	 * @param province
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public ProvinceResult add(@RequestBody Province province) {

		return provinceService.add(province);
	}

	/**
	 * 通过id查询省级单位
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public ProvinceResult findById(@PathVariable("id") String id) {

		return provinceService.findById(id);
	}

	/**
	 * 通过id修改省级单位
	 * @param id
	 * @param province
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public ProvinceResult edit(@PathVariable("id") String id, @RequestBody Province province) {

		return provinceService.edit(id,province);
	}

	/**
	 * 通过id删除省级单位
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return provinceService.delete(id);
	}
	
}