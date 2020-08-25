package com.module.service.department;

import com.common.response.CommonCode;
import com.common.response.QueryResponseResult;
import com.common.response.QueryResult;
import com.common.response.ResponseResult;
import com.module.dao.department.DepartmentDao;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentPageRequest;
import com.module.response.department.DepartmentPageResult;
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
	private DepartmentDao dao;

    public QueryResponseResult findList(int page, int size, DepartmentPageRequest departmentPageRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (departmentPageRequest == null) {
            departmentPageRequest = new DepartmentPageRequest();
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
    public DepartmentPageResult add(Department department) {
        Department one = dao.get(department.getDepartmentId());
        if (one == null) {
            one.setDepartmentId("123456");
            one.setDepartmentName(department.getDepartmentName());
            one.setRemark(department.getRemark());
            one.setCreatDate(new Date());
           dao.insert(department);
            //成功了，所以返回内容里面是CommonCode.SUCCESS
            DepartmentPageResult departmentPageResult = new DepartmentPageResult(CommonCode.SUCCESS, department);
            return departmentPageResult;
        }else{
            //测试捕获自定义异常
            //ExceptionCast.cast(CmsCode.CMS_ADDPAGE_EXISTSNAME);
        }
        //新增页面失败时，则返回的是CommonCode.FAIL
        return new DepartmentPageResult(CommonCode.FAIL, null);
    }

    /**
     * 通过ID查询部门
     * @param id
     * @return
     */
    public Department findById(String id) {
        Department one = dao.get(id);
        System.out.printf("findById查询到的one:"+one.toString());
        if (one != null) {
            return one;
        }
        return null;
    }

	/**
	 * 通过id修改部门
	 * @param id
	 * @return
	 */
	public DepartmentPageResult edit(String id, Department department) {
        Department one = dao.get(id);
        if (one != null) {
            one.setDepartmentId(department.getDepartmentId());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemark(department.getRemark());
            int save = dao.update(one);
            if (save > 0) {
                //返回成功
                DepartmentPageResult departmentPageResult = new DepartmentPageResult(CommonCode.SUCCESS, department);
                return departmentPageResult;
            }
        }
        //返回失败
        return new DepartmentPageResult(CommonCode.FAIL, null);
	}

	/**
	 * 通过id删除部门
	 * @param id
	 * @return
	 */
	public ResponseResult delete(String id) {
        Department one = dao.get(id);
        if (one != null) {
            dao.delete(one.getDepartmentId());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
	}

}