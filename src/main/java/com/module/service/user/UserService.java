package com.module.service.user;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.user.UserDao;
import com.module.entity.user.User;

import com.module.request.user.UserRequest;
import com.module.response.user.UserCode;
import com.module.response.user.UserResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户Service
 * Created by huangbotao on 2020/9/1;
 */

@Service
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserResult login(User user) {
        String userId = userDao.login(user);

        if (userId == null) {
            ExceptionCast.cast(UserCode.CMS_UPDATE_FALSE);
        }
            return new UserResult(CommonCode.SUCCESS,user);

    }

    public QueryResponseResult findList(int page, int size, UserRequest userRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (userRequest == null) {
            userRequest = new UserRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        List<User> list = userDao.findList();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Transactional
    public UserResult add(User user) {
        User one = new User();
        one.setUserId(IdGen.uuid());
        one.setCreateDate(user.getCreateDate());
        one.setUserName(user.getUserName());
        one.setPassword(user.getPassword());
        one.setUserJurisdiction(user.getUserJurisdiction());
        one.setRemark(user.getRemark());
        int insert = userDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new UserResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(UserCode.CMS_INSERT_FALSE);
        }
        //返回失败
        return new UserResult(UserCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    public UserResult findById(String id) {
        if (userDao.get(id) != null) {
            User user = userDao.get(id);
            //返回成功
            return new UserResult(CommonCode.SUCCESS, user);
        }
        //返回失败
        return new UserResult(UserCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改用户
     * @param id
     * @return
     */
    @Transactional
    public UserResult edit(String id, User user) {
        if (userDao.get(id) != null) {
            User one = userDao.get(id);
            one.setCreateDate(user.getCreateDate());
            one.setUserName(user.getUserName());
            one.setPassword(user.getPassword());
            one.setUserJurisdiction(user.getUserJurisdiction());
            one.setRemark(user.getRemark());
            int update = userDao.update(one);
            if (update > 0) {
                //返回成功
                return new UserResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(UserCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new UserResult(UserCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除用户
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (userDao.get(id) != null) {
            int delete = userDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(UserCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new UserResult(UserCode.CMS_GET_ISNULL, null);
    }


}

