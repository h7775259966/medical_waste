package com.module.service.system.role;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.CryptoUtil;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.system.role.UserAndRoleDao;
import com.module.dao.system.role.UserDao;
import com.module.entity.system.role.User;
import com.module.entity.system.role.UserAndRole;
import com.module.request.system.role.UserAndRoleRequest;
import com.module.request.system.role.UserRequest;
import com.module.response.system.role.UserCode;
import com.module.response.system.role.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 *用户Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private UserDao userDao;

    @Autowired
    private UserAndRoleDao userAndRoleDao;

    //通过key加密用户密码
	private static final String key ="lfzn";


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
        List<User> list = userDao.findListByRequest(userRequest);
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
        if (userDao.getByName(user.getUserName()) == null) {
            User one = new User();
            one.setId(IdGen.uuid());
            one.setUserName(user.getUserName());
            String newpassword = CryptoUtil.encode(key, user.getPassWord());
            one.setPassWord(newpassword);//明文密码加密后再保存
            one.setStatus(1);//新增启用状态默认为:1为启用
            one.setMobile(user.getMobile());
            one.setEmail(user.getEmail());
            one.setNickName(user.getNickName());
            one.setUnitId(user.getUnitId());
            one.setGrade(user.getGrade());
            one.setRemarks(user.getRemarks());
            one.setCreateDate(new Date());
            int insert = userDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new UserResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(UserCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new UserResult(UserCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询用户
     * @param id
     * @return
     */
    public UserResult findById(String id) {
        if (userDao.get(id) != null) {
            User user = userDao.get(id);
            String newpassword = CryptoUtil.decode(key,user.getPassWord());
            user.setPassWord(newpassword);
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
            one.setUserName(user.getUserName());
            String newpassword = CryptoUtil.encode(key,user.getPassWord());
            one.setPassWord(newpassword);//明文密码加密后再保存
            //one.setStatus(1);
            one.setMobile(user.getMobile());
            one.setEmail(user.getEmail());
            one.setNickName(user.getNickName());
            one.setUnitId(user.getUnitId());
            one.setGrade(user.getGrade());
            one.setRemarks(user.getRemarks());
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
                userAndRoleDao.deleteByuserId(id);
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


    /**
     * 通过id修改用户状态
     * @param id
     * @return
     */
    @Transactional
    public UserResult editStatus(String id,Integer status) {
        if (userDao.get(id) != null && status != null) {
            User one = userDao.get(id);
            one.setStatus(status);
            int update = userDao.editStatus(one);
            if (update > 0) {
                //返回成功
                return new UserResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(UserCode.CMS_EDITSTATUS_FALSE);
            }
        }
        //返回失败
        return new UserResult(UserCode.CMS_GET_ISNULL, null);
    }

    /**
     * 给用户分配角色
     * @param userAndRoleRequest
     * @return
     */
    @Transactional
    public ResponseResult assignRoles(UserAndRoleRequest userAndRoleRequest) {
        if (userDao.get(userAndRoleRequest.getUserId()) != null) {
            List<String> roleIdList = userAndRoleRequest.getRoleId();
            if (roleIdList.size()>0){
                //分配角色前，先将中间表旧数据删除
                userAndRoleDao.deleteByuserId(userAndRoleRequest.getUserId());
                for (int i = 0; i <roleIdList.size() ; i++) {
                    UserAndRole userAndRole = new UserAndRole();
                    userAndRole.setId(IdGen.uuid());
                    userAndRole.setCreateDate(new Date());
                    userAndRole.setUserId(userAndRoleRequest.getUserId());
                    userAndRole.setRoleId(roleIdList.get(i));
                    userAndRoleDao.insert(userAndRole);
                }
                return new ResponseResult(CommonCode.SUCCESS);
            }
        }
        //返回失败
        return new ResponseResult(UserCode.CMS_ASSIGNROLES_FALSE);
    }
}