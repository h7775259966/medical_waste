package com.module.dao.warnRecord;

import com.common.CrudDao.CrudDao;
import com.module.entity.warnRecord.WarnRecord;
import org.apache.ibatis.annotations.Mapper;


/**
 * 预警记录DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnRecordDao extends CrudDao<WarnRecord>{

}