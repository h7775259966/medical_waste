package com.module.service.system.permission;

import com.common.Response.*;
import com.common.Utils.BeanMapUtils;
import com.common.Utils.IdGen;
import com.common.Utils.PermissionConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.system.permission.PermissionApiDao;
import com.module.dao.system.permission.PermissionDao;
import com.module.dao.system.permission.PermissionMenuDao;
import com.module.dao.system.permission.PermissionPointDao;
import com.module.entity.system.permission.*;
import com.common.Request.system.permission.PermissionRequest;
import com.common.Response.system.permission.PermissionCode;
import com.common.Response.system.permission.PermissionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *权限Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private PermissionApiDao permissionApiDao;

    @Autowired
    private PermissionMenuDao permissionMenuDao;

    @Autowired
    private PermissionPointDao permissionPointDao;


    public QueryResponseResult findList(int page, int size, PermissionRequest permissionRequest) {
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, null);
        try {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (permissionRequest == null) {
            permissionRequest = new PermissionRequest();
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
        List<Permission> list = permissionDao.findListByRequest(permissionRequest);
        List<PermissionAll> list2 = new ArrayList<PermissionAll>();
            if(list.size()>0){
                for (int i = 0; i <list.size(); i++) {
                    Permission permission = list.get(i);
                    if (getPermissionAllById(permission.getId())!=null){
                        PermissionAll permissionAll = getPermissionAllById(permission.getId());
                        list2.add(permissionAll);
                    }
                }
            }
        PageInfo<PermissionAll> pageInfo = new PageInfo<PermissionAll>(list2);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list2);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
            queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
            return queryResponseResult;
        } catch (Exception e) {
            e.printStackTrace();
            return queryResponseResult;
        }
    }

    /**
     * 查询所有权限
     * @return
     */
    public QueryResponseResult all() {
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.FAIL, null);
        try{
        List<Permission> list = permissionDao.findList();
        List<PermissionAll> list2 = new ArrayList<PermissionAll>();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Permission permission = list.get(i);
                if (getPermissionAllById(permission.getId())!=null){
                    PermissionAll permissionAll = getPermissionAllById(permission.getId());
                    list2.add(permissionAll);
                }
            }
        }
        PageInfo<PermissionAll> pageInfo = new PageInfo<PermissionAll>(list2);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list2);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    } catch (Exception e) {
        e.printStackTrace();
        return queryResponseResult;
    }
    }
    /**
     * 添加权限
     * @param permissionAll
     * @return
     */
    @Transactional
    public PermissionResult add(PermissionAll permissionAll){
        if ( permissionDao.getByName(permissionAll.getName()) == null) {
            try {
                //设置统一的权限id
                String id = IdGen.uuid();
                Map<String, Object> map = BeanMapUtils.beanToMap(permissionAll);
                //2.根据类型构造不同的资源对象(菜单,按钮,api)
                int type = permissionAll.getType();
                switch (type) {
                    case PermissionConstants.PERMISSION_MENU:
                        PermissionMenu menu = BeanMapUtils.mapToBean(map, PermissionMenu.class);
                        menu.setId(id);
                        permissionMenuDao.insert(menu);
                        break;
                    case PermissionConstants.PERMISSION_POINT:
                        PermissionPoint point = BeanMapUtils.mapToBean(map, PermissionPoint.class);
                        point.setId(id);
                        permissionPointDao.insert(point);
                        break;
                    case PermissionConstants.PERMISSION_API:
                        PermissionApi api = BeanMapUtils.mapToBean(map, PermissionApi.class);
                        api.setId(id);
                        permissionApiDao.insert(api);
                        break;
                    default:
                        return new PermissionResult(PermissionCode.CMS_INSERT_FALSE,null);
                }
                //3.保存数据
                Permission permission = BeanMapUtils.mapToBean(map, Permission.class);
                permission.setId(id);
                permission.setCreateDate(new Date());
                permissionAll.setId(id);
                permissionAll.setCreateDate(new Date());
                permissionDao.insert(permission);
                return new PermissionResult(CommonCode.SUCCESS, permissionAll);
            } catch (Exception e) {
                e.printStackTrace();
                return new PermissionResult(PermissionCode.CMS_INSERT_FALSE,null);
            }
        }
        return new PermissionResult(PermissionCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id查询权限
     * @param id
     * @return
     */
    public PermissionResult findById(String id) {
        if (getPermissionAllById(id)!=null){
            PermissionAll permissionAll = getPermissionAllById(id);
            return new PermissionResult(CommonCode.SUCCESS, permissionAll);
        }else{
            //返回失败
            return new PermissionResult(PermissionCode.CMS_GET_ISNULL, null);
        }
    }

    /**
     * 通过权限id获得对应的PermissionAll
     * @param id
     * @return
     */
    public PermissionAll getPermissionAllById(String id){
        if (permissionDao.get(id) != null) {
            PermissionAll permissionAll = new PermissionAll();
            try {
                Permission permission = permissionDao.get(id);
                Object object = null;
                int type = permission.getType();
                switch (type) {
                    case PermissionConstants.PERMISSION_MENU:
                        object = permissionMenuDao.get(id);
                        break;
                    case PermissionConstants.PERMISSION_POINT:
                        object = permissionPointDao.get(id);
                        break;
                    case PermissionConstants.PERMISSION_API:
                        object = permissionApiDao.get(id);
                        break;
                    default:
                       break;
                }
                Map<String, Object> map = BeanMapUtils.beanToMap(object);
                map.put("name",permission.getName());
                map.put("type",permission.getType());
                map.put("code",permission.getCode());
                map.put("description",permission.getRemarks());
                map.put("pid",permission.getPid());
                map.put("enVisible",permission.getEnVisible());
                permissionAll = BeanMapUtils.mapToBean(map, PermissionAll.class);
                //返回成功
                return permissionAll;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /**
     * 通过id修改权限
     * @param id
     * @return
     */
    @Transactional
    public PermissionResult edit(String id, PermissionAll permissionAll) {
        if ( permissionDao.getByName(permissionAll.getName()) == null) {
            try {
                Map<String, Object> map = BeanMapUtils.beanToMap(permissionAll);
                int type = permissionAll.getType();
                switch (type) {
                    case PermissionConstants.PERMISSION_MENU:
                        PermissionMenu menu = BeanMapUtils.mapToBean(map, PermissionMenu.class);
                        menu.setId(id);
                        permissionMenuDao.update(menu);
                        break;
                    case PermissionConstants.PERMISSION_POINT:
                        PermissionPoint point = BeanMapUtils.mapToBean(map, PermissionPoint.class);
                        point.setId(id);
                        permissionPointDao.update(point);
                        break;
                    case PermissionConstants.PERMISSION_API:
                        PermissionApi api = BeanMapUtils.mapToBean(map, PermissionApi.class);
                        api.setId(id);
                        permissionApiDao.update(api);
                        break;
                    default:
                        return new PermissionResult(PermissionCode.CMS_UPDATE_FALSE,null);
                }
                //3.保存数据
                Permission permission = BeanMapUtils.mapToBean(map, Permission.class);
                permission.setId(id);
                permissionAll.setId(id);
                permissionDao.update(permission);
                return new PermissionResult(CommonCode.SUCCESS, permissionAll);
            } catch (Exception e) {
                e.printStackTrace();
                return new PermissionResult(PermissionCode.CMS_UPDATE_FALSE,null);
            }
        }
        return new PermissionResult(PermissionCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id删除权限
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (permissionDao.get(id) != null) {
            Permission permission = permissionDao.get(id);
            int type = permission.getType();
            switch (type) {
                case PermissionConstants.PERMISSION_MENU:
                    permissionMenuDao.delete(id);
                    break;
                case PermissionConstants.PERMISSION_POINT:
                    permissionPointDao.delete(id);
                    break;
                case PermissionConstants.PERMISSION_API:
                    permissionApiDao.delete(id);
                    break;
                default:
                    return new PermissionResult(PermissionCode.CMS_GET_ISNULL, null);
            }
            int delete = permissionDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(PermissionCode.CMS_DELETE_FALSE);
                return new PermissionResult(PermissionCode.CMS_DELETE_FALSE, null);
            }
        }
        //返回失败
        return new PermissionResult(PermissionCode.CMS_GET_ISNULL, null);
    }

}