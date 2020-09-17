package com.module.dao.warn.warnNoOut;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.warnNoOut.WarnNoOut;
import org.apache.ibatis.annotations.Mapper;


/**
 * 未出预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnNoOutDao extends CrudDao<WarnNoOut>{

}