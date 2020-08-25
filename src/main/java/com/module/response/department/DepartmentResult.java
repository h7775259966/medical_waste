package com.module.response.department;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.department.Department;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将部门相关数据封装在这里，然后返回给前端
 */
@Data
public class DepartmentResult extends ResponseResult {
    Department department;
    public DepartmentResult(ResultCode resultCode, Department department) {
        super(resultCode);
        this.department = department;
    }
}
