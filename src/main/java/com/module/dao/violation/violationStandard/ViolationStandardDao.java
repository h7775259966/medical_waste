package com.module.dao.violation.violationStandard;

import com.common.CrudDao.CrudDao;
import com.module.entity.violation.violationStandard.ViolationStandard;

import java.util.List;

/**
 * Created by huangbotao on 2020/8/28;
 */
public interface ViolationStandardDao extends CrudDao<ViolationStandard> {

    /**
     * 通过状态查询所有违规标准
     * @param status
     * @return
     */
    public List<ViolationStandard> findAllByStatus(Integer  status);

    /**
     *  通过id修改用户状态
     * @param violationStandard
     * @return
     */
    public int editStatus(ViolationStandard violationStandard);
}
