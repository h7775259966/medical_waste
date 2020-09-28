package com.module.dao.hospitalSwitch;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospitalSwitch.SwitchWarn;
import com.module.entity.hospitalSwitch.SwitchWeight;
import org.apache.ibatis.annotations.Mapper;

/**
 * 重量阈值功能DAO接口
 * @author zx
 * @version 2020/9/28
 */
@Mapper
public interface SwitchWeightDao extends CrudDao<SwitchWeight>{


}