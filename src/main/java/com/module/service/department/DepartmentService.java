package com.module.service.department;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.module.dao.department.DepartmentDao;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentPageRequest;
import com.module.response.department.DepartmentPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
        Department one = departmentDao.get(department.getDepartmentId());
        if (one == null) {
            one.setDepartmentId(IdGen.uuid());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            one.setCreateDate(new Date());
            departmentDao.insert(department);
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
        System.out.println("service的id:"+id);
        System.out.println("测试IdGen.uuid()："+IdGen.uuid());
        Department one = departmentDao.get(id);
        System.out.printf("findById查询到的one:"+one.toString());
        if (one != null) {
            String Datestr2 = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf2 = new SimpleDateFormat(Datestr2);
            String creatDate = sdf2.format(one.getCreateDate());
            System.out.println("查询获取的one.getCreatDate()："+one.getCreateDate());
            System.out.println("转化的creatDate："+creatDate);
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
        Department one = departmentDao.get(id);
        if (one != null) {
            one.setDepartmentId(department.getDepartmentId());
            one.setDepartmentName(department.getDepartmentName());
            one.setRemarks(department.getRemarks());
            int save = departmentDao.update(one);
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
        Department one = departmentDao.get(id);
        if (one != null) {
            departmentDao.delete(one.getDepartmentId());
            return new ResponseResult(CommonCode.SUCCESS);
        }
        return new ResponseResult(CommonCode.FAIL);
	}

}