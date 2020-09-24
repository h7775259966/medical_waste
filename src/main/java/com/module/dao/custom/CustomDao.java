package com.module.dao.custom;

import com.common.CrudDao.CrudDao;
import com.module.entity.custom.Custom;
import com.module.entity.hospital.department.Department;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.entity.warn.warnInWeight.WarnInWeight;
import com.module.entity.warn.warnLeakage.WarnLeakage;
import com.module.entity.warn.warnLose.WarnLose;
import com.module.entity.warn.warnNoOut.WarnNoOut;
import com.module.entity.warn.warnOutOvertime.WarnOutOvertime;
import com.module.entity.warn.warnOutWeight.WarnOutWeight;
import com.module.entity.warn.warnType.WarnType;
import com.common.Request.custom.CustomRequest;
import com.common.Request.custom.CustomWarnRequest;
import com.module.entity.warn.warnViolation.WarnViolation;
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

    public List<WarnInWeight> customInWeight(CustomWarnRequest customWarnRequest);

    public List<WarnLeakage> customLeakage(CustomWarnRequest customWarnRequest);

    public List<WarnLose> customLose(CustomWarnRequest customWarnRequest);

    public List<WarnNoOut> customNoOut(CustomWarnRequest customWarnRequest);

    public List<WarnOutOvertime> customOutOvertime(CustomWarnRequest customWarnRequest);

    public List<WarnOutWeight> customOutWeight(CustomWarnRequest customWarnRequest);

    public List<WarnViolation> customViolation(CustomWarnRequest customWarnRequest);

}
