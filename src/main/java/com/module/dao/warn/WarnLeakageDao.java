package com.module.dao.warn;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.WarnLeakage;
import org.apache.ibatis.annotations.Mapper;


/**
 * 泄漏预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnLeakageDao extends CrudDao<WarnLeakage>{

}