package com.module.service.system.user;

import com.common.Response.*;
import com.common.Utils.CryptoUtil;
import com.common.Utils.IdGen;
import com.common.Utils.JwtUtils;
import com.common.Utils.PermissionConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.system.role.RoleDao;
import com.module.dao.system.user.UserAndRoleDao;
import com.module.dao.system.user.UserDao;
import com.module.entity.system.permission.PermissionAll;
import com.module.entity.system.role.*;
import com.common.Request.system.user.LoginRequest;
import com.common.Request.system.user.UserAndRoleRequest;
import com.common.Request.system.user.UserRequest;
import com.common.Response.system.user.LoginResult;
import com.common.Response.system.user.UserCode;
import com.common.Response.system.user.UserResult;
import com.module.entity.system.user.User;
import com.module.entity.system.user.UserAndRole;
import com.module.service.system.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    private RoleDao roleDao;

    @Autowired
    private UserAndRoleDao userAndRoleDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private JwtUtils jwtUtils;

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
            one.setStatus(2);//新增默认启用(启用状态 1为禁用 2为启用)
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
     * 通过id查询用户
     * (同时查询出此用户下分配的角色)
     * @param id
     * @return
     */
    @Transactional
    public MapResult findById(String id) {
        if (userDao.get(id) != null) {
            Map<String,Object> map = new HashMap<>();
            User user = userDao.get(id);
            map.put("user",user);
            List<Role> roleList = findRoleByUserId(id);
            if(roleList.size()>0){
                map.put("roleList",roleList);
            }
            String newpassword = CryptoUtil.decode(key,user.getPassWord());
            user.setPassWord(newpassword);
            //返回成功
            return new MapResult(CommonCode.SUCCESS, map);
        }
        //返回失败
        return new MapResult(UserCode.CMS_GET_ISNULL, null);
    }

    /**
     * 根据用户id查询对应的所有角色
     * @param id
     * @return
     */
    @Transactional
    public List<Role> findRoleByUserId(String id){
        List<UserAndRole> list = userAndRoleDao.getByUserId(id);
        List<Role> roleList = new ArrayList<Role>();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                UserAndRole userAndRole = list.get(i);
                Role role = roleDao.get(userAndRole.getRoleId());
                roleList.add(role);
            }
        }
        return roleList;
    }

    /**
     * 根据用户id查询用户包含角色下的所有权限
     * @param id
     * @return
     */
    @Transactional
    public List<PermissionAll> findPermissionAllByUserId(String id){
        List<PermissionAll> list = new ArrayList<>();
        List<Role> roleList = findRoleByUserId(id);
        if(roleList.size()>0){
            for (int i = 0; i <roleList.size(); i++) {
                Role role = roleList.get(i);
                List<PermissionAll> PermissionAllList = roleService.findPermissionAllByRoleId(role.getId());
                if (PermissionAllList.size()>0){
                    list = PermissionAllList;
                }
            }
        }
        return list;
    }

	/**
	 * 通过id修改用户
     * (安全考虑，用户名和状态无法修改)
	 * @param id
	 * @return
	 */
    @Transactional
	public UserResult edit(String id, User user) {
        if (userDao.get(id) != null) {
            User one = userDao.get(id);
            //one.setUserName(user.getUserName());
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
                userAndRoleDao.deleteByUserId(id);
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
     * 通过id修改状态
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
                userAndRoleDao.deleteByUserId(userAndRoleRequest.getUserId());
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

    /**
     * 用户登录
     * 认证后返回token
     * @param loginRequest
     * @return
     */
    @Transactional
    public LoginResult login(LoginRequest loginRequest) {
        if (userDao.getByName(loginRequest.getUserName()) != null) {
            User user = userDao.getByName(loginRequest.getUserName());
            if (user.getStatus() != 0) {
                String password = CryptoUtil.encode(key, loginRequest.getPassWord());
                if(!user.getPassWord().equals(password)) {
                    //密码认证失败
                    return new LoginResult(UserCode.CMS_LOGIN_FALSE,null);
                }else{
                    //密码认证成功
                    //查询此用户下所有角色的api权限
                    StringBuilder apis = new StringBuilder();
                    List<PermissionAll> PermissionAllList = findPermissionAllByUserId(user.getId());
                    if (PermissionAllList.size()>0){
                        for (int j = 0; j <PermissionAllList.size(); j++) {
                            PermissionAll permissionAll = PermissionAllList.get(j);
                            if (permissionAll.getType() == PermissionConstants.PERMISSION_API){
                                //将此用户下所有api权限拼接后存入token,用于调用其他接口时的api鉴权校验
                                apis.append(permissionAll.getCode()).append(",");
                            }
                        }
                    }
                    Map<String,Object> map = new HashMap<>();
                    map.put("apis",apis.toString());//可访问的api权限字符串
                    map.put("userId",user.getId());
                    map.put("unitId",user.getUnitId());
                    map.put("grade",user.getGrade());
                    String token = jwtUtils.createJwt(user.getId(), user.getUserName(), map);
                    return new LoginResult(UserCode.CMS_LOGIN_TRUE,token);
                }
            }else{
                return new LoginResult(UserCode.CMS_LOGIN_NO,null);
            }
        }
        return new LoginResult(UserCode.CMS_LOGIN_FALSE,null);
    }

    /**
     * 通过用户id获取用户的所有权限标识
     * @param id
     * @return
     */
    @Transactional
    public Map<String, Object> profile(String id){
        Map<String,Object> map = new HashMap<>();
        User user = userDao.get(id);
        map.put("user",user);
        List<PermissionAll> PermissionAllList = findPermissionAllByUserId(id);
        Map<String, Object> codeList = new HashMap<>();
        Set<String> menus = new HashSet<>();
        Set<String> points = new HashSet<>();
        Set<String> apis = new HashSet<>();
        if (PermissionAllList.size()>0) {
            for (int j = 0; j < PermissionAllList.size(); j++) {
                PermissionAll permissionAll = PermissionAllList.get(j);
                String code = permissionAll.getCode();
                if (permissionAll.getType() == PermissionConstants.PERMISSION_MENU) {
                    menus.add(code);
                }else if(permissionAll.getType() == PermissionConstants.PERMISSION_POINT){
                    points.add(code);
                }else{
                    apis.add(code);
                }
            }
        }
        codeList.put("menus", menus);
        codeList.put("points", points);
        codeList.put("apis", apis);
        map.put("codeList",codeList);
        return map;
    }
}