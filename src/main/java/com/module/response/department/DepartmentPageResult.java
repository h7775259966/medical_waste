package com.module.response.department;

import com.common.response.ResponseResult;
import com.common.response.ResultCode;
import com.module.entity.department.Department;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 */
@Data
public class DepartmentPageResult extends ResponseResult {
    Department department;
    public DepartmentPageResult(ResultCode resultCode, Department department) {
        super(resultCode);
        this.department = department;
    }
}
