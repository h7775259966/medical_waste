package com.module.dao.warn;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.WarnInOvertime;
import org.apache.ibatis.annotations.Mapper;


/**
 * 入库超时预警预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnInOvertimeDao extends CrudDao<WarnInOvertime>{

}