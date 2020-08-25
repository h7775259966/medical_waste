package com.module.dao.department;

import com.common.CrudDao.CrudDao;
import com.module.entity.department.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

/**
 * 医院部门DAO接口
 * @author zx
 * @version 2020-08-24
 */
@Mapper
public interface DepartmentDao extends CrudDao<Department> {
	
}