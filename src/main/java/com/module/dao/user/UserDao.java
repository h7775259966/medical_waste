package com.module.dao.user;

import com.common.CrudDao.CrudDao;
import com.module.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by huangbotao on 2020/9/1;
 */

@Mapper
public interface UserDao extends CrudDao<User> {
    String login(User user);
}
