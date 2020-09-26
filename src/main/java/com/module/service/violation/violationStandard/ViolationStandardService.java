package com.module.service.violation.violationStandard;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.violation.violationStandard.ViolationStandardDao;
import com.module.entity.violation.violationStandard.ViolationStandard;
import com.common.Request.violation.violationStandard.ViolationStandardRequest;
import com.common.Response.violation.violationStandard.ViolationStandardResult;
import com.common.Response.violation.violationStandard.ViolationStandardCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 违规标准Service
 * Created by huangbotao on 2020/8/27;
 */
@Service
@Transactional(readOnly = true)
public class ViolationStandardService {

    @Autowired
    private ViolationStandardDao violationStandardDao;

    public QueryResponseResult findList(int page, int size, ViolationStandardRequest violationStandardRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (violationStandardRequest == null) {
            violationStandardRequest = new ViolationStandardRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        //注意：如果violationStandardRequest内参数不为空，则进行带值查询
        //violationStandardDao.findList()为没有任何查询条件的分页查询
        List<ViolationStandard> list = violationStandardDao.findList();
        PageInfo<ViolationStandard> pageInfo = new PageInfo<ViolationStandard>(list);

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 查询所有状态为启用的违规标准
     * //状态:1为启用 0为禁用
     * @return
     */
    public QueryResponseResult all() {
        List<ViolationStandard> list = violationStandardDao.findAllByStatus(1);//状态:1为启用 0为禁用
        PageInfo<ViolationStandard> pageInfo = new PageInfo<ViolationStandard>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加违规标准
     * @param violationStandard
     * @return
     */
    @Transactional
    public ViolationStandardResult add(ViolationStandard violationStandard) {
        if (violationStandardDao.getByName(violationStandard.getViolationStandardName()) == null) {
            ViolationStandard one = new ViolationStandard();
            one.setViolationStandardId(IdGen.uuid());
            one.setCreateDate(new Date());
            one.setViolationStandardName(violationStandard.getViolationStandardName());
            one.setPunishmentWay(violationStandard.getPunishmentWay());
            one.setAdministrativePenalty(violationStandard.getAdministrativePenalty());
            one.setGrade(violationStandard.getGrade());
            one.setStatus(violationStandard.getStatus());
            one.setRemark(violationStandard.getRemark());
            int insert = violationStandardDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new ViolationStandardResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationStandardCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new ViolationStandardResult(ViolationStandardCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id查询违规标准
     * @param id
     * @return
     */
    public ViolationStandardResult findById(String id) {
        if (violationStandardDao.get(id) != null) {
            ViolationStandard violationStandard = violationStandardDao.get(id);
            //返回成功
            return new ViolationStandardResult(CommonCode.SUCCESS, violationStandard);
        }
        //返回失败
        return new ViolationStandardResult(ViolationStandardCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改违规标准
     * @param id
     * @return
     */
    @Transactional
    public ViolationStandardResult edit(String id, ViolationStandard violationStandard) {
        if (violationStandardDao.get(id) != null) {
            ViolationStandard one = violationStandardDao.get(id);
            one.setCreateDate(new Date());
            one.setViolationStandardName(violationStandard.getViolationStandardName());
            one.setPunishmentWay(violationStandard.getPunishmentWay());
            one.setAdministrativePenalty(violationStandard.getAdministrativePenalty());
            one.setGrade(violationStandard.getGrade());
            one.setStatus(violationStandard.getStatus());
            one.setRemark(violationStandard.getRemark());
            int update = violationStandardDao.update(one);
            if (update > 0) {
                //返回成功
                return new ViolationStandardResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationStandardCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ViolationStandardResult(ViolationStandardCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除违规标准
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (violationStandardDao.get(id) != null) {
            int delete = violationStandardDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationStandardCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ViolationStandardResult(ViolationStandardCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改违规标准状态
     * @param id
     * @return
     */
    @Transactional
    public ViolationStandardResult editStatus(String id, Integer status) {
        if (violationStandardDao.get(id) != null && status != null) {
            ViolationStandard one = violationStandardDao.get(id);
            one.setStatus(status);
            int update = violationStandardDao.editStatus(one);
            if (update > 0) {
                //返回成功
                return new ViolationStandardResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationStandardCode.CMS_EDITSTATUS_FALSE);
            }
        }
        //返回失败
        return new ViolationStandardResult(ViolationStandardCode.CMS_GET_ISNULL, null);
    }
}
