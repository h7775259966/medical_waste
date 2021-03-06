package com.module.dao.system.user;

import com.common.CrudDao.CrudDao;
import com.module.entity.system.user.User;
import com.common.Request.system.user.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 用户DAO接口
 * @author zx
 * @version 2020-09-18
 */
@Mapper
public interface UserDao extends CrudDao<User> {

    /**
     * 通过查询条件查询所有数据
     * @param userRequest
     * @return
     */
    public List<User> findListByRequest(UserRequest userRequest);

    /**
     *  通过id修改用户状态
     * @param user
     * @return
     */
    public int editStatus(User user);
}