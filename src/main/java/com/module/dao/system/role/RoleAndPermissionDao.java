package com.module.dao.system.role;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.role.RoleAndPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 给角色分配权限(中间表)DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface RoleAndPermissionDao extends CrudDao<RoleAndPermission> {

    /**
     * 根据roleId查询所有数据
     * @param roleId
     * @return
     */
    public List<RoleAndPermission> getByRoleId(String roleId);

    /**
     * 根据roleId删除所有中间表数据
     * @param roleId
     * @return
     */
    public int deleteByRoleId(String roleId);
}