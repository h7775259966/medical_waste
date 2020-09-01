package com.module.dao.warn.warnType;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.warnType.WarnType;
import org.apache.ibatis.annotations.Mapper;


/**
 * 预警类型DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnTypeDao extends CrudDao<WarnType>{

}