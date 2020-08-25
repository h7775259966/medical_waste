package com.module.dao.User;

import com.common.CrudDao.CrudDao;
import com.module.entity.User.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends CrudDao<User> {
    /**
     * 查询user表所有数据
     * @return
     */
    public List<User> queryUserList();

}
