package com.module.controller.hospital.zone;


import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.hospital.zone.Zone;
import com.common.Request.hospital.zone.ZoneRequest;
import com.common.Response.hospital.zone.ZoneResult;
import com.module.service.hospital.zone.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 区县级单位Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/zone")
public class ZoneController implements ZoneControllerApi {

	@Autowired
	private ZoneService zoneService;

	/**
	 * 分页同时自定义查询
	 * @param page
	 * @param size
	 * @param zoneRequest
	 * @return
	 */
	@Override
	@GetMapping("/list/{page}/{size}")
	public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, ZoneRequest zoneRequest) {

		return zoneService.findList(page,size, zoneRequest);
	}


	/**
	 * 查询所有区县级单位
	 * @param
	 * @return
	 */
	@Override
	@GetMapping("/all")
	public QueryResponseResult all() {

		return zoneService.all();
	}

	/**
	 * 添加区县级单位
	 * @param zone
	 * @return
	 */
	@Override
	@PostMapping("/add")
	public ZoneResult add(@RequestBody Zone zone) {

		return zoneService.add(zone);
	}

	/**
	 * 通过id查询区县级单位
	 * @param id
	 * @return
	 */
	@Override
	@GetMapping("/get/{id}")
	public ZoneResult findById(@PathVariable("id") String id) {

		return zoneService.findById(id);
	}

	/**
	 * 通过id修改区县级单位
	 * @param id
	 * @param zone
	 * @return
	 */
	@Override
	@PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
	public ZoneResult edit(@PathVariable("id") String id, @RequestBody Zone zone) {

		return zoneService.edit(id,zone);
	}

	/**
	 * 通过id删除区县级单位
	 * @param id
	 * @return
	 */
	@Override
	@DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
	public ResponseResult delete(@PathVariable("id") String id) {

		return zoneService.delete(id);
	}

	/**
	 * 通过市级id查询所属区县级
	 * @param CityId
	 * @return
	 */
	@Override
	@GetMapping("/findByCityId/{CityId}")
	public QueryResponseResult findByCityId(@PathVariable("CityId") String CityId) {

		return zoneService.findByCityId(CityId);
	}
}