package com.module.dao.custom;

import com.common.CrudDao.CrudDao;
import com.module.entity.custom.Custom;
import com.module.entity.hospital.department.Department;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.entity.warn.warnType.WarnType;
import com.module.request.custom.CustomRequest;
import com.module.request.custom.CustomWarnRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 *
 * 自定义查询接口
 * Created by huangbotao on 2020/9/21;
 */
@Mapper
public interface CustomDao extends CrudDao<TrashCollect> {

    public List<Custom> customFind(CustomRequest customRequest);

    public List<WarnType> customWarn(CustomWarnRequest customWarnRequest);

}
