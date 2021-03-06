package com.module.service.system.role;

import com.common.Response.*;
import com.common.Utils.PermissionConstants;
import com.module.dao.system.permission.PermissionDao;
import com.module.dao.system.role.RoleAndPermissionDao;
import com.module.entity.system.permission.Permission;
import com.module.entity.system.permission.PermissionAll;
import com.module.entity.system.role.*;
import com.common.Request.system.role.RoleAndPermissionRequest;
import com.common.Response.system.role.RoleResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.system.role.RoleDao;
import com.common.Request.system.role.RoleRequest;
import com.common.Response.system.role.RoleCode;
import com.module.entity.system.user.User;
import com.module.service.system.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *角色Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionDao permissionDao;

	@Autowired
    private RoleAndPermissionDao roleAndPermissionDao;

	@Autowired
    private PermissionService permissionService;


    public QueryResponseResult findList(int page, int size, RoleRequest roleRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (roleRequest == null) {
            roleRequest = new RoleRequest();
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
        List<Role> list = roleDao.findListByRequest(roleRequest);
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 查询所有角色
     * @return
     */
    public QueryResponseResult all() {
        List<Role> list = roleDao.findList();
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Transactional
    public RoleResult add(Role role) {
        if (roleDao.getByName(role.getRoleName()) == null) {
            Role one = new Role();
            one.setId(IdGen.uuid());
            one.setRoleName(role.getRoleName());
            one.setUnitId(role.getUnitId());
            one.setGrade(role.getGrade());
            one.setRemarks(role.getRemarks());
            one.setCreateDate(new Date());
            int insert = roleDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new RoleResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RoleCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new RoleResult(RoleCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id查询角色
     * (同时查询出此角色下分配的权限)
     * @param id
     * @return
     */
    public MapResult findById(String id) {
        if (roleDao.get(id) != null) {
            Map<String,Object> map = new HashMap<>();
            Role role = roleDao.get(id);
            map.put("role",role);
            List<PermissionAll> permissionAllList = findPermissionAllByRoleId(id);
            if(permissionAllList.size()>0){
                map.put("permissionAllList",permissionAllList);
            }
            //返回成功
            return new MapResult(CommonCode.SUCCESS, map);
        }
        //返回失败
        return new MapResult(RoleCode.CMS_GET_ISNULL, null);
    }

    /**
     * 根据角色id查询对应的所有权限
     * @param id
     * @return
     */
    public List<PermissionAll> findPermissionAllByRoleId(String id){
        List<RoleAndPermission> list = roleAndPermissionDao.getByRoleId(id);
        List<PermissionAll> permissionAllList = new ArrayList<PermissionAll>();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                RoleAndPermission roleAndPermission = list.get(i);
                if (permissionService.getPermissionAllById(roleAndPermission.getPermissionId())!=null){
                    PermissionAll permissionAll = permissionService.getPermissionAllById(roleAndPermission.getPermissionId());
                    permissionAllList.add(permissionAll);
                }
            }
        }
        return  permissionAllList;
    }

    /**
	 * 通过id修改角色
	 * @param id
	 * @return
	 */
    @Transactional
	public RoleResult edit(String id, Role role) {
        if (roleDao.get(id) != null) {
            Role one = roleDao.get(id);
            one.setRoleName(role.getRoleName());
            one.setUnitId(role.getUnitId());
            one.setGrade(role.getGrade());
            one.setRemarks(role.getRemarks());
            int update = roleDao.update(one);
            if (update > 0) {
                //返回成功
                return new RoleResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RoleCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new RoleResult(RoleCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除角色
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (roleDao.get(id) != null) {
            int delete = roleDao.delete(id);
            if (delete > 0) {
                roleAndPermissionDao.deleteByRoleId(id);
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RoleCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new RoleResult(RoleCode.CMS_GET_ISNULL, null);
	}

    /**
     * 给角色添加权限
     * @param roleAndPermissionRequest
     * @return
     */
    @Transactional
    public ResponseResult assignPrem(RoleAndPermissionRequest roleAndPermissionRequest) {
        if (roleDao.get(roleAndPermissionRequest.getRoleId()) != null) {
            List<String> PermissionList = roleAndPermissionRequest.getPermissionId();
            if (PermissionList.size()>0) {
                //分配权限前，先将中间表旧数据删除
                roleAndPermissionDao.deleteByRoleId(roleAndPermissionRequest.getRoleId());
                List<Permission> perms = new ArrayList<Permission>();
                for (int i = 0; i < PermissionList.size(); i++) {
                    Permission permission = permissionDao.get(PermissionList.get(i));
                    perms.add(permission);//当前菜单或按钮的权限
                    //需要根据父id和类型查询API权限列表
                    List<Permission> apiList = permissionDao.findByTypeAndPid(PermissionConstants.PERMISSION_API, PermissionList.get(i));
                    if (apiList.size()>0) {
                        perms.addAll(apiList);//pid等于这个权限id的API权限
                    }
                }
                for (int k = 0; k <perms.size(); k++) {
                    Permission permission2 = perms.get(k);
                    RoleAndPermission roleAndPermission = new RoleAndPermission();
                    roleAndPermission.setId(IdGen.uuid());
                    roleAndPermission.setCreateDate(new Date());
                    roleAndPermission.setRoleId(roleAndPermissionRequest.getRoleId());
                    roleAndPermission.setPermissionId(permission2.getId());
                    roleAndPermissionDao.insert(roleAndPermission);
                }
                return new ResponseResult(CommonCode.SUCCESS);
            }
        }
        //返回失败
        return new ResponseResult(RoleCode.CMS_ASSIGNROLES_FALSE);
    }

}