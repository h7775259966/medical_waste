package com.module.dao.warnInWeight;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnInWeight.WarnInWeight;
import com.module.entity.warnOutWeight.WarnOutWeight;
import org.apache.ibatis.annotations.Mapper;


/**
 * 入库重量预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnInWeightDao extends CrudDao<WarnInWeight>{

}