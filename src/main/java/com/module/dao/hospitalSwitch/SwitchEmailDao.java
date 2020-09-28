package com.module.dao.hospitalSwitch;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospitalSwitch.SwitchEmail;
import org.apache.ibatis.annotations.Mapper;

/**
 * 邮件功能DAO接口
 * @author zx
 * @version 2020/9/28
 */
@Mapper
public interface SwitchEmailDao extends CrudDao<SwitchEmail>{


}