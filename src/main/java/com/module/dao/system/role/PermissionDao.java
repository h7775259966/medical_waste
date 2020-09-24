package com.module.dao.system.role;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.role.Permission;
import com.common.Request.system.role.PermissionRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 权限DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface PermissionDao extends CrudDao<Permission> {

    /**
     * 通过查询条件查询所有数据
     * @param permissionRequest
     * @return
     */
    public List<Permission> findListByRequest(PermissionRequest permissionRequest);

    /**
     * 通过类型和父级id查询相关权限数据
     * @param type
     * @param pid
     * @return
     */
    public List<Permission> findByTypeAndPid(int type,String pid);

}