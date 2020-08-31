package com.module.dao.warnOutWeight;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnOutWeight.WarnOutWeight;
import org.apache.ibatis.annotations.Mapper;


/**
 * 出库重量预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnOutWeightDao extends CrudDao<WarnOutWeight>{

}