package com.module.dao.hospitalSwitch;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospitalSwitch.SwitchTime;
import org.apache.ibatis.annotations.Mapper;

/**
 * 预警时限功能DAO接口
 * @author zx
 * @version 2020/9/28
 */
@Mapper
public interface SwitchTimeDao extends CrudDao<SwitchTime>{


}