package com.module.service.violationExamine;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.violation.violationExamine.ViolationExamineDao;
import com.module.entity.violation.violationExamine.ViolationExamine;
import com.module.request.violation.violationExamine.ViolationExamineRequest;
import com.module.response.violation.violationExamine.ViolationExamineCode;
import com.module.response.violation.violationExamine.ViolationExamineResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by huangbotao on 2020/8/28;
 */
@Service
@Transactional(readOnly = true)
public class ViolationExamineService {

    @Autowired
    private ViolationExamineDao violationExamineDao;

    public QueryResponseResult findList(int page, int size, ViolationExamineRequest violationExamineRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (violationExamineRequest == null) {
            violationExamineRequest = new ViolationExamineRequest();
        }
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        //注意：如果violationExamineRequest内参数不为空，则进行带值查询
        //violationExamineDao.findList()为没有任何查询条件的分页查询
        List<ViolationExamine> list = violationExamineDao.findList();
        PageInfo<ViolationExamine> pageInfo = new PageInfo<ViolationExamine>(list);

        /*System.out.println("总数量：" + pageInfo.getTotal());
        System.out.println("当前页查询记录：" + pageInfo.getList().size());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("每页显示数量：" + pageInfo.getPageSize());
        System.out.println("总页：" + pageInfo.getPages());*/

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加违规检查
     * @param violationExamine
     * @return
     */
    @Transactional
    public ViolationExamineResult add(ViolationExamine violationExamine) {

        ViolationExamine one = new ViolationExamine();
        one.setViolationExamineId(IdGen.uuid());
        one.setCreateDate(new Date());
        one.setHospitalId(violationExamine.getHospitalId());
        one.setWriteTime(violationExamine.getWriteTime());
        one.setWay(violationExamine.getWay());
        one.setContent(violationExamine.getContent());
        one.setStatus(violationExamine.getStatus());
        one.setPhotograph(violationExamine.getPhotograph());
        one.setAbarbeitungTime(violationExamine.getAbarbeitungTime());
        one.setViolationTime(violationExamine.getViolationTime());
        int insert = violationExamineDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new ViolationExamineResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(ViolationExamineCode.CMS_INSERT_FALSE);
        }

        //返回失败
        return new ViolationExamineResult(ViolationExamineCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询违规检查
     * @param id
     * @return
     */
    public ViolationExamineResult findById(String id) {
        if (violationExamineDao.get(id) != null) {
            ViolationExamine violationExamine = violationExamineDao.get(id);
            //返回成功
            return new ViolationExamineResult(CommonCode.SUCCESS, violationExamine);
        }
        //返回失败
        return new ViolationExamineResult(ViolationExamineCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改违规检查
     * @param id
     * @return
     */
    @Transactional
    public ViolationExamineResult edit(String id, ViolationExamine violationExamine) {
        if (violationExamineDao.get(id) != null) {
            ViolationExamine one = violationExamineDao.get(id);
            one.setCreateDate(new Date());
            one.setHospitalId(violationExamine.getHospitalId());
            one.setWriteTime(violationExamine.getWriteTime());
            one.setWay(violationExamine.getWay());
            one.setContent(violationExamine.getContent());
            one.setStatus(violationExamine.getStatus());
            one.setPhotograph(violationExamine.getPhotograph());
            one.setAbarbeitungTime(violationExamine.getAbarbeitungTime());
            one.setViolationTime(violationExamine.getViolationTime());
            int update = violationExamineDao.update(one);
            if (update > 0) {
                //返回成功
                return new ViolationExamineResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationExamineCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new ViolationExamineResult(ViolationExamineCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除违规检查
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (violationExamineDao.get(id) != null) {
            int delete = violationExamineDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(ViolationExamineCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new ViolationExamineResult(ViolationExamineCode.CMS_GET_ISNULL, null);
    }

}
