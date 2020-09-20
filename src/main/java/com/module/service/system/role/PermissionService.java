package com.module.service.system.role;

import com.common.Response.*;
import com.common.Utils.BeanMapUtils;
import com.common.Utils.IdGen;
import com.common.Utils.PermissionConstants;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.system.role.PermissionApiDao;
import com.module.dao.system.role.PermissionDao;
import com.module.dao.system.role.PermissionMenuDao;
import com.module.dao.system.role.PermissionPointDao;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.office.Office;
import com.module.entity.system.role.*;
import com.module.request.system.role.PermissionRequest;
import com.module.response.system.role.PermissionCode;
import com.module.response.system.role.PermissionResult;
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
                Object object = null;
                int type = permission.getType();
                switch (type) {
                    case PermissionConstants.PERMISSION_MENU:
                        object = permissionMenuDao.get(permission.getId());
                        break;
                    case PermissionConstants.PERMISSION_POINT:
                        object = permissionPointDao.get(permission.getId());
                        break;
                    case PermissionConstants.PERMISSION_API:
                        object = permissionApiDao.get(permission.getId());
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
                PermissionAll permissionAll = BeanMapUtils.mapToBean(map, PermissionAll.class);
                list2.add(permissionAll);
            }
        }
        PageInfo<PermissionAll> pageInfo = new PageInfo<PermissionAll>(list2);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
            return queryResponseResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new PermissionResult(PermissionCode.CMS_INSERT_FALSE,null);
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
     * 通过ID查询权限
     * @param id
     * @return
     */
    public PermissionResult findById(String id) {
        if (permissionDao.get(id) != null) {
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
                    return new PermissionResult(PermissionCode.CMS_GET_ISNULL, null);
            }
            Map<String, Object> map = BeanMapUtils.beanToMap(object);
            map.put("name",permission.getName());
            map.put("type",permission.getType());
            map.put("code",permission.getCode());
            map.put("description",permission.getRemarks());
            map.put("pid",permission.getPid());
            map.put("enVisible",permission.getEnVisible());
            PermissionAll permissionAll = BeanMapUtils.mapToBean(map, PermissionAll.class);
            //返回成功
            return new PermissionResult(CommonCode.SUCCESS, permissionAll);
            } catch (Exception e) {
                e.printStackTrace();
                return new PermissionResult(PermissionCode.CMS_GET_ISNULL,null);
            }
        }
        //返回失败
        return new PermissionResult(PermissionCode.CMS_GET_ISNULL, null);
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