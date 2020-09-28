package com.module.dao.hospitalSwitch;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospitalSwitch.SwitchWarn;
import org.apache.ibatis.annotations.Mapper;

/**
 * 预警功能DAO接口
 * @author zx
 * @version 2020/9/28
 */
@Mapper
public interface SwitchWarnDao extends CrudDao<SwitchWarn>{


}