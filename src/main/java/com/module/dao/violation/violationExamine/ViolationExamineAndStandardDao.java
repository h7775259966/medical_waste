package com.module.dao.violation.violationExamine;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.user.UserAndRole;
import com.module.entity.violation.violationExamine.ViolationExamineAndStandard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 给违规检查分配违规标准(中间表)DAO接口
 * Created by Zhouxin on 2020/9/25;
 */
@Mapper
public interface ViolationExamineAndStandardDao extends CrudDao<ViolationExamineAndStandard> {
    /**
     * 根据violationExamineId查询所有数据
     * @param violationExamineId
     * @return
     */
    public List<ViolationExamineAndStandard> getByViolationExamineId(String violationExamineId);

    /**
     * 根据violationExamineIdd删除所有中间表数据
     * @param violationExamineId
     * @return
     */
    public int deleteByViolationExamineId(String violationExamineId);
}
