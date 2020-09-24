package com.module.dao.warn.warnLose;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.warnLose.WarnLose;
import org.apache.ibatis.annotations.Mapper;


/**
 * 遗失预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnLoseDao extends CrudDao<WarnLose>{

}