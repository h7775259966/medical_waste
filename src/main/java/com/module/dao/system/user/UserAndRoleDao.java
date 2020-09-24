package com.module.dao.system.user;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.user.UserAndRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 给用户分配角色(中间表)DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface UserAndRoleDao extends CrudDao<UserAndRole> {

    /**
     * 根据userId查询所有数据
     * @param userId
     * @return
     */
    public List<UserAndRole> getByUserId(String userId);

    /**
     * 根据userId删除所有中间表数据
     * @param userId
     * @return
     */
    public int deleteByUserId(String userId);
}