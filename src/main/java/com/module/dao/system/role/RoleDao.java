package com.module.dao.system.role;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.role.Role;
import com.module.entity.system.role.User;
import com.module.request.system.role.RoleRequest;
import com.module.request.system.role.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 角色DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface RoleDao extends CrudDao<Role> {

    /**
     * 通过查询条件查询所有数据
     * @param roleRequest
     * @return
     */
    public List<Role> findListByRequest(RoleRequest roleRequest);

}