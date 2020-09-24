package com.module.dao.system.permission;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.permission.PermissionMenu;
import org.apache.ibatis.annotations.Mapper;


/**
 * 菜单权限DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface PermissionMenuDao extends CrudDao<PermissionMenu> {

}