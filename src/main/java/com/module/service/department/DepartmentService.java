package com.module.service.department;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.department.DepartmentDao;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentRequest;
import com.module.response.department.DepartmentCode;
import com.module.response.department.DepartmentResult;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 医院部门Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentDao departmentDao;

    public QueryResponseResult findList(int page, int size, DepartmentRequest departmentRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (departmentRequest == null) {
            departmentRequest = new DepartmentRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        //注意：如果departmentRequest内参数不为空，则进行带值查询
        //departmentDao.findList()为没有任何查询条件的分页查询
        List<Department> list = departmentDao.findListByRequest(departmentRequest);
        PageInfo<Department> pageInfo = new PageInfo<Department>(list);

        /*System.out.println("总数量：" + pageInfo.getTotal());
        System.out.println("当前页查询记录：" + pageInfo.getList().size());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("每页显示数量：" + pageInfo.getPageSize());
        System.out.println("总页：" + pageInfo.getPages());*/

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 查询所有部门
     * @return
     */
    public QueryResponseResult all() {
        List<Department> list = departmentDao.findList();
        PageInfo<Department> pageInfo = new PageInfo<Department>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Transactional
    public DepartmentResult add(Department department) {
        if (departmentDao.getByName(department.getDepartmentName()) == null) {
            Department one = new Department();
            one.setDepartmentId(IdGen.uuid());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            one.setCreateDate(new Date());
            int insert = departmentDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new DepartmentResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DepartmentCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new DepartmentResult(DepartmentCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询部门
     * @param id
     * @return
     */
    public DepartmentResult findById(String id) {
        if (departmentDao.get(id) != null) {
            Department department = departmentDao.get(id);
            //返回成功
            return new DepartmentResult(CommonCode.SUCCESS, department);
        }
        //返回失败
        return new DepartmentResult(DepartmentCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改部门
	 * @param id
	 * @return
	 */
    @Transactional
	public DepartmentResult edit(String id, Department department) {
        if (departmentDao.get(id) != null) {
            Department one = departmentDao.get(id);
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            int update = departmentDao.update(one);
            if (update > 0) {
                //返回成功
                return new DepartmentResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DepartmentCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new DepartmentResult(DepartmentCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除部门
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (departmentDao.get(id) != null) {
            int delete = departmentDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(DepartmentCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new DepartmentResult(DepartmentCode.CMS_GET_ISNULL, null);
	}

}