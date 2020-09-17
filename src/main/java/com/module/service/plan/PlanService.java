package com.module.service.plan;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.hospital.hospital.HospitalDao;
import com.module.dao.plan.PlanDao;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.hospital.Hospital;
import com.module.entity.hospital.nurse.Nurse;
import com.module.entity.hospital.office.Office;
import com.module.entity.plan.Plan;
import com.module.request.plan.PlanRequest;
import com.module.response.plan.PlanCode;
import com.module.response.plan.PlanResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 计划Service
 * Created by huangbotao on 2020/8/27;
 */
@Service
@Transactional(readOnly = true)
public class PlanService {

    @Autowired
    private PlanDao planDao;

    @Autowired
    private HospitalDao hospitalDao;

    public QueryResponseResult findList(int page, int size, PlanRequest planRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (planRequest == null) {
            planRequest = new PlanRequest();
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
        //注意：如果planRequest内参数不为空，则进行带值查询
        //planDao.findList()为没有任何查询条件的分页查询
        List<Plan> list = planDao.findList();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Plan plan = list.get(i);
                if (hospitalDao.get(plan.getHospitalId()) != null) {
                    Hospital hospital = hospitalDao.get(plan.getHospitalId());
                    plan.setHospitalName(hospital.getHospitalName());
                }else{
                    plan.setHospitalName("");
                }

            }
        }
        PageInfo<Plan> pageInfo = new PageInfo<Plan>(list);

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
     * 添加计划
     * @param plan
     * @return
     */
    @Transactional
    public PlanResult add(Plan plan) {
        if (planDao.getByName(plan.getPlanName()) == null) {
            Plan one = new Plan();
            one.setPlanId(IdGen.uuid());
            one.setCreateDate(new Date());
            one.setPlanName(plan.getPlanName());
            one.setWriteTime(plan.getWriteTime());
            one.setWriteUnit(plan.getWriteUnit());
            one.setContent(plan.getContent());
            one.setHospitalId(plan.getHospitalId());
            one.setFinishNumber(plan.getFinishNumber());
            one.setUnfinishNumber(plan.getUnfinishNumber());
            one.setStatus(plan.getStatus());
            one.setRemark(plan.getRemark());
            int insert = planDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new PlanResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(PlanCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new PlanResult(PlanCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询计划
     * @param id
     * @return
     */
    @Transactional
    public PlanResult findById(String id) {
        if (planDao.get(id) != null) {
            Plan plan = planDao.get(id);
            //返回成功
            return new PlanResult(CommonCode.SUCCESS, plan);
        }
        //返回失败
        return new PlanResult(PlanCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id修改计划
     * @param id
     * @return
     */
    @Transactional
    public PlanResult edit(String id, Plan plan) {
        if (planDao.get(id) != null) {
            Plan one = planDao.get(id);
            one.setCreateDate(new Date());
            one.setPlanName(plan.getPlanName());
            one.setWriteTime(plan.getWriteTime());
            one.setWriteUnit(plan.getWriteUnit());
            one.setContent(plan.getContent());
            one.setHospitalId(plan.getHospitalId());
            one.setFinishNumber(plan.getFinishNumber());
            one.setUnfinishNumber(plan.getUnfinishNumber());
            one.setStatus(plan.getStatus());
            one.setRemark(plan.getRemark());
            int update = planDao.update(one);
            if (update > 0) {
                //返回成功
                return new PlanResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(PlanCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new PlanResult(PlanCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除计划
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (planDao.get(id) != null) {
            int delete = planDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(PlanCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new PlanResult(PlanCode.CMS_GET_ISNULL, null);
    }

}
