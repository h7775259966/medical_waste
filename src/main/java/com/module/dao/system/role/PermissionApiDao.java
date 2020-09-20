package com.module.dao.system.role;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.role.PermissionApi;
import org.apache.ibatis.annotations.Mapper;


/**
 * API权限DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface PermissionApiDao extends CrudDao<PermissionApi> {

}