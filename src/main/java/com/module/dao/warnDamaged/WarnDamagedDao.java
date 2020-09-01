package com.module.dao.warnDamaged;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnDamaged.WarnDamaged;
import com.module.entity.warnLose.WarnLose;
import org.apache.ibatis.annotations.Mapper;


/**
 * 破损预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnDamagedDao extends CrudDao<WarnDamaged>{

}