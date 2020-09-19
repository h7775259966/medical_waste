package com.module.service.system.role;

import com.module.response.system.role.RoleResult;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.CryptoUtil;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.system.role.RoleDao;
import com.module.entity.system.role.Role;
import com.module.request.system.role.RoleRequest;
import com.module.response.system.role.RoleCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
     * 通过ID查询角色
     * @param id
     * @return
     */
    public RoleResult findById(String id) {
        if (roleDao.get(id) != null) {
            Role role = roleDao.get(id);
            //返回成功
            return new RoleResult(CommonCode.SUCCESS, role);
        }
        //返回失败
        return new RoleResult(RoleCode.CMS_GET_ISNULL, null);
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

}