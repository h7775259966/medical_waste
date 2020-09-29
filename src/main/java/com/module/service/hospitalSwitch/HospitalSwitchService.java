package com.module.service.hospitalSwitch;

import com.common.Response.CommonCode;
import com.common.Response.hospitalSwitch.HospitalSwitchCode;
import com.common.Response.hospitalSwitch.HospitalSwitchResult;
import com.module.dao.hospital.hospital.HospitalDao;
import com.module.dao.hospitalSwitch.*;
import com.module.entity.hospitalSwitch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * 医院功能开关管理Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class HospitalSwitchService {

    @Autowired
    private HospitalDao hospitalDao;

	@Autowired
	private SwitchEmailDao switchEmailDao;

    @Autowired
    private SwitchTimeDao switchTimeDao;

    @Autowired
    private SwitchWarnDao switchWarnDao;

    @Autowired
    private SwitchWeightDao switchWeightDao;

    @Autowired
    private SwitchWeightDifferDao switchWeightDifferDao;


    /**
     * 根据医院id查询所有功能开关
     * @param hospitalId
     * @return
     */
    public HospitalSwitchResult findByHospitalId(String hospitalId) {
        if (hospitalDao.get(hospitalId) != null) {
            HospitalSwitch hospitalSwitch = new HospitalSwitch();
            if (switchEmailDao.get(hospitalId)!=null) {
                hospitalSwitch.setSwitchEmail(switchEmailDao.get(hospitalId));
            }else {
                hospitalSwitch.setSwitchEmail(new SwitchEmail());
            }

            if (switchTimeDao.get(hospitalId)!=null) {
                hospitalSwitch.setSwitchTime(switchTimeDao.get(hospitalId));
            }else {
                hospitalSwitch.setSwitchTime(new SwitchTime());
            }

            if (switchWarnDao.get(hospitalId)!=null) {
                hospitalSwitch.setSwitchWarn(switchWarnDao.get(hospitalId));
            }else {
                hospitalSwitch.setSwitchWarn(new SwitchWarn());
            }

            if (switchWeightDao.get(hospitalId)!=null) {
                hospitalSwitch.setSwitchWeight(switchWeightDao.get(hospitalId));
            }else {
                hospitalSwitch.setSwitchWeight(new SwitchWeight());
            }

            if (switchWeightDifferDao.get(hospitalId)!=null) {
                hospitalSwitch.setSwitchWeightDiffer(switchWeightDifferDao.get(hospitalId));
            }else {
                hospitalSwitch.setSwitchWeightDiffer(new SwitchWeightDiffer());
            }

            //返回成功
            return new HospitalSwitchResult(CommonCode.SUCCESS, hospitalSwitch);
        }
        //返回失败
        return new HospitalSwitchResult(HospitalSwitchCode.CMS_GET_ISNULL, null);
    }


    /**
     * 通过医院id保存所有功能开关
     * @param hospitalId
     * @param hospitalSwitch
     * @return
     */
    @Transactional
    public HospitalSwitchResult save(String hospitalId, HospitalSwitch hospitalSwitch) {
        boolean result = deletAllSwitchById(hospitalId);
        if (result) {
            SwitchEmail switchEmail = hospitalSwitch.getSwitchEmail();
            switchEmail.setHospitalId(hospitalId);
            switchEmail.setCreateDate(new Date());
            switchEmailDao.insert(switchEmail);

            SwitchTime switchTime = hospitalSwitch.getSwitchTime();
            switchTime.setHospitalId(hospitalId);
            switchTime.setCreateDate(new Date());
            switchTimeDao.insert(switchTime);

            SwitchWarn switchWarn = hospitalSwitch.getSwitchWarn();
            switchWarn.setHospitalId(hospitalId);
            switchWarn.setCreateDate(new Date());
            switchWarnDao.insert(switchWarn);

            SwitchWeight switchWeight = hospitalSwitch.getSwitchWeight();
            switchWeight.setHospitalId(hospitalId);
            switchWeight.setCreateDate(new Date());
            switchWeightDao.insert(switchWeight);

            SwitchWeightDiffer switchWeightDiffer = hospitalSwitch.getSwitchWeightDiffer();
            switchWeightDiffer.setHospitalId(hospitalId);
            switchWeightDiffer.setCreateDate(new Date());
            switchWeightDifferDao.insert(switchWeightDiffer);

            //返回成功
            return new HospitalSwitchResult(CommonCode.SUCCESS, hospitalSwitch);
        }
        //返回失败
        return new HospitalSwitchResult(HospitalSwitchCode.CMS_GET_ISNULL, null);
    }


    /**
     * 根据医院id删除所有关联的功能开关
     * @param hospitalId
     * @return
     */
    public boolean deletAllSwitchById(String hospitalId){
        if (hospitalDao.get(hospitalId) != null) {
            switchEmailDao.delete(hospitalId);
            switchTimeDao.delete(hospitalId);
            switchWarnDao.delete(hospitalId);
            switchWeightDao.delete(hospitalId);
            switchWeightDifferDao.delete(hospitalId);
            return true;
        }
        return false;
    }
}