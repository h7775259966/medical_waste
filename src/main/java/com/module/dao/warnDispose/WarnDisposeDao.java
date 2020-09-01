package com.module.dao.warnDispose;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnDispose.WarnDispose;
import org.apache.ibatis.annotations.Mapper;


/**
 * 预警处理DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnDisposeDao extends CrudDao<WarnDispose>{

}