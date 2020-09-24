package com.module.dao.warn.warnViolation;

import com.common.CrudDao.CrudDao;
import com.module.entity.warn.warnViolation.WarnViolation;
import org.apache.ibatis.annotations.Mapper;


/**
 * 违规预警DAO接口
 * @author zx
 * @version 2020-08-26
 */
@Mapper
public interface WarnViolationDao extends CrudDao<WarnViolation>{

}