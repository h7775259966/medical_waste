package com.module.dao.violation.violationHistory;

import com.common.CrudDao.CrudDao;
import com.module.entity.violation.violationExamine.ViolationExamine;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by huangbotao on 2020/9/21;
 */
@Mapper
public interface ViolationHistoryDao extends CrudDao<ViolationExamine> {
}
