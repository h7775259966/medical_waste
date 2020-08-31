package com.module.dao.warnOutOvertime;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnOutOvertime.WarnOutOvertime;
import org.apache.ibatis.annotations.Mapper;


/**
 * 出库超时预警预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnOutOvertimeDao extends CrudDao<WarnOutOvertime>{

}