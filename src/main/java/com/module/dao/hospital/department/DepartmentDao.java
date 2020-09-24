package com.module.dao.hospital.department;

import com.common.CrudDao.CrudDao;
import com.module.entity.hospital.department.Department;
import com.common.Request.hospital.department.DepartmentRequest;
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