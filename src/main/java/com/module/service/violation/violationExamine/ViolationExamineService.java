package com.module.service.violation.violationExamine;

import com.common.Response.*;
import com.common.Response.system.user.UserCode;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.violation.violationExamine.ViolationExamineAndStandardDao;
import com.module.dao.violation.violationExamine.ViolationExamineDao;
import com.module.dao.violation.violationStandard.ViolationStandardDao;
import com.module.entity.violation.violationExamine.ViolationExamine;
import com.common.Request.violation.violationExamine.ViolationExamineRequest;
import com.common.Response.violation.violationExamine.ViolationExamineCode;
import com.common.Response.violation.violationExamine.ViolationExamineResult;
import com.module.entity.violation.violationExamine.ViolationExamineAndStandard;
import com.module.entity.violation.violationStandard.ViolationStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 违规检查Service
 * Created by huangbotao on 2020/8/28;
 */
@Service
@Transactional(readOnly = true)
public class ViolationExamineService {

    @Autowired
    private ViolationExamineDao violationExamineDao;

    @Autowired
    private ViolationStandardDao violationStandardDao;

    @Autowired
    private ViolationExamineAndStandardDao violationExamineAndStandardDao;

    public QueryResponseResult findList(int page, int size, ViolationExamineRequest violationExamineRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (violationExamineRequest == null) {
            violationExamineRequest = new ViolationExamineRequest();
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
        List<ViolationExamine> list = violationExamineDao.findList();
        PageInfo<ViolationExamine> pageInfo = new PageInfo<ViolationExamine>(list);
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
        String ViolationExamineId = IdGen.uuid();
        ViolationExamine one = new ViolationExamine();
        one.setViolationExamineId(ViolationExamineId);
        one.setCreateDate(new Date());
        one.setHospitalId(violationExamine.getHospitalId());
        one.setWriteTime(violationExamine.getWriteTime());
        one.setWay(violationExamine.getWay());
        one.setContent(violationExamine.getContent());
        one.setStatus(violationExamine.getStatus());
        one.setPhotograph(violationExamine.getPhotograph());
        one.setAbarbeitungTime(violationExamine.getAbarbeitungTime());
        one.setViolationTime(violationExamine.getViolationTime());
        one.setViolationStandardIdList(violationExamine.getViolationStandardIdList());
        int insert = violationExamineDao.insert(one);
        if (insert > 0 ) {
            saveViolationStandardIdList(ViolationExamineId, violationExamine.getViolationStandardIdList());
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
     * 根据违规检查id保存分配的所有违规标准
     * @param ViolationExamineId
     * @param StandardIdList
     * @return
     */
    @Transactional
    public int saveViolationStandardIdList(String ViolationExamineId, List<String> StandardIdList){
        int result = 0;
        if (StandardIdList.size()>0){
            for (int i = 0; i <StandardIdList.size(); i++) {
                ViolationExamineAndStandard EAndS = new ViolationExamineAndStandard();
                EAndS.setId(IdGen.uuid());
                EAndS.setViolationExamineId(ViolationExamineId);
                EAndS.setViolationStandardId(StandardIdList.get(i));
                EAndS.setCreateDate(new Date());
                int insert = violationExamineAndStandardDao.insert(EAndS);
                result = result + insert;
            }
        }
        return result;
    }

    /**
     * 通过id查询违规检查
     * (同时查询出此违规检查下的所有违规标准)
     * @param id
     * @return
     */
    @Transactional
    public MapResult findById(String id) {
        if (violationExamineDao.get(id) != null) {
            Map<String,Object> map = new HashMap<>();
            ViolationExamine violationExamine = violationExamineDao.get(id);
            map.put("violationExamine",violationExamine);
            List<ViolationStandard> list = findViolationStandardListById(id);
            map.put("ViolationStandardList",list);
            //返回成功
            return new MapResult(CommonCode.SUCCESS, map);
        }
        //返回失败
        return new MapResult(UserCode.CMS_GET_ISNULL, null);
    }

    /**
     * 根据违规检查id查询对应的所有违规标准
     * @param id
     * @return
     */
    @Transactional
    public List<ViolationStandard> findViolationStandardListById(String id){
        List<ViolationExamineAndStandard> list = violationExamineAndStandardDao.getByViolationExamineId(id);
        List<ViolationStandard> StandardList = new ArrayList<ViolationStandard>();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                ViolationExamineAndStandard EAndS = list.get(i);
                ViolationStandard Standard = violationStandardDao.get(EAndS.getViolationStandardId());
                StandardList.add(Standard);
            }
        }
        return StandardList;
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
            one.setViolationStandardIdList(violationExamine.getViolationStandardIdList());
            int update = violationExamineDao.update(one);
            if (update > 0) {
                violationExamineAndStandardDao.deleteByViolationExamineId(id);
                saveViolationStandardIdList(id,violationExamine.getViolationStandardIdList());
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
                violationExamineAndStandardDao.deleteByViolationExamineId(id);
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
