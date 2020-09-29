package com.module.controller.hospitalSwitch;


import com.common.Response.hospital.hospital.HospitalResult;
import com.common.Response.hospitalSwitch.HospitalSwitchResult;
import com.module.entity.hospital.hospital.Hospital;
import com.module.entity.hospitalSwitch.HospitalSwitch;
import com.module.service.hospitalSwitch.HospitalSwitchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 医院功能开关管理Controller
 * @author zx
 * @version 2020-08-24
 */
@RestController
@RequestMapping("/hospitalSwitch")
public class HospitalSwitchController implements HospitalSwitchControllerApi{

	@Autowired
	private HospitalSwitchService hospitalSwitchService;


	/**
	 * 根据医院id查询所有功能开关
	 * @param hospitalId
	 * @return
	 */
	@Override
	@GetMapping("/get/{hospitalId}")
	public HospitalSwitchResult findByHospitalId(@PathVariable("hospitalId") String hospitalId) {

		return hospitalSwitchService.findByHospitalId(hospitalId);
	}

	/**
	 * 通过医院id保存所有功能开关
	 * @param hospitalId
	 * @param hospitalSwitch
	 * @return
	 */
	@Override
	@PutMapping("/save/{hospitalId}")
	public HospitalSwitchResult save(@PathVariable("hospitalId") String hospitalId, @RequestBody HospitalSwitch hospitalSwitch) {

		return hospitalSwitchService.save(hospitalId, hospitalSwitch);
	}
}