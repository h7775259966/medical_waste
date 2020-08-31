package com.module.dao.department;

import com.common.CrudDao.CrudDao;
import com.module.entity.department.Department;
import com.module.request.department.DepartmentRequest;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


/**
 * 医院部门DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface DepartmentDao extends CrudDao<Department>{

    /**
     * 通过查询条件查询所有数据
     * @param departmentRequest
     * @return
     */
    public List<Department> findListByRequest(DepartmentRequest departmentRequest);
}