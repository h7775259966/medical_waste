package com.module.dao.trashType;

import com.common.CrudDao.CrudDao;
import com.module.entity.trashType.TrashType;
import org.apache.ibatis.annotations.Mapper;


/**
 * 医废类型DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface TrashTypeDao extends CrudDao<TrashType>{

}