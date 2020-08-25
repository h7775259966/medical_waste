package com.module.service.department;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.module.dao.department.DepartmentDao;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentRequest;
import com.module.response.department.DepartmentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
        //分页加自定义查询处理


        //封装结果
        QueryResult queryResult = new QueryResult();
        //queryResult.setList();//数据列表
        //queryResult.setTotal();//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    public DepartmentResult add(Department department) {
        Department one = departmentDao.get(department.getDepartmentId());
        if (one == null) {
            one.setDepartmentId(IdGen.uuid());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            one.setCreateDate(new Date());
            departmentDao.insert(department);
            //成功了，所以返回内容里面是CommonCode.SUCCESS
            DepartmentResult departmentResult = new DepartmentResult(CommonCode.SUCCESS, department);
            return departmentResult;
        }else{
            //测试捕获自定义异常
            //ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        //新增页面失败时，则返回的是CommonCode.FAIL
        return new DepartmentResult(CommonCode.FAIL, null);
    }

    /**
     * 通过ID查询部门
     * @param id
     * @return
     */
    public DepartmentResult findById(String id) {
        Department department = departmentDao.get(id);
        if (department != null) {
            //返回成功
            DepartmentResult departmentResult = new DepartmentResult(CommonCode.SUCCESS, department);
            return departmentResult;
        }
        //返回失败
        return new DepartmentResult(CommonCode.FAIL, null);
    }

	/**
	 * 通过id修改部门
	 * @param id
	 * @return
	 */
	public DepartmentResult edit(String id, Department department) {
        Department one = departmentDao.get(id);
        if (one != null) {
            one.setDepartmentId(department.getDepartmentId());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            int save = departmentDao.update(one);
            if (save > 0) {
                //返回成功
                DepartmentResult departmentResult = new DepartmentResult(CommonCode.SUCCESS, department);
                return departmentResult;
            }
        }
        //返回失败
        return new DepartmentResult(CommonCode.FAIL, null);
	}

	/**
	 * 通过id删除部门
	 * @param id
	 * @return
	 */
	public ResponseResult delete(String id) {
        Department one = departmentDao.get(id);
        if (one != null) {
            departmentDao.delete(one.getDepartmentId());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
	}

}