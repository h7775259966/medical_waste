package com.module.service.trash.trashCollect;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.trash.trashCollect.TrashCollectDao;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.request.trash.trashCollect.TrashCollectRequest;
import com.module.response.trash.trashCollect.TrashCollectCode;
import com.module.response.trash.trashCollect.TrashCollectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 医废收集Service
 * Created by huangbotao on 2020/8/31;
 */
@Service
@Transactional(readOnly = true)
public class TrashCollectService {

    @Autowired
    private TrashCollectDao trashCollectDao;


    public QueryResponseResult findList(int page, int size, TrashCollectRequest trashCollectRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashCollectRequest == null) {
            trashCollectRequest = new TrashCollectRequest();
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
        //注意：如果equipmentRequest内参数不为空，则进行带值查询
        //departmentDao.findList()为没有任何查询条件的分页查询
        List<TrashCollect> list = trashCollectDao.findList();
        PageInfo<TrashCollect> pageInfo = new PageInfo<TrashCollect>(list);

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
     * 添加医废收集
     * @param trashCollect
     * @return
     */
    @Transactional
    public TrashCollectResult add(TrashCollect trashCollect) {
            TrashCollect one = new TrashCollect();
            one.setTrashCollectId(IdGen.uuid());
            one.setCreateDate(trashCollect.getCreateDate());
            one.setOfficeId(trashCollect.getOfficeId());
            one.setDepartmentId(trashCollect.getDepartmentId());
            one.setCode(trashCollect.getCode());
            one.setTrashId(trashCollect.getTrashId());
            one.setPackets(trashCollect.getPackets());
            one.setCollectMethods(trashCollect.getCollectMethods());
            one.setEquipmentId(trashCollect.getEquipmentId());
            one.setCollectId(trashCollect.getCollectId());
            one.setCollectNumber(trashCollect.getCollectNumber());
            one.setViolationWeight(trashCollect.getViolationWeight());
            int insert = trashCollectDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new TrashCollectResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashCollectCode.CMS_INSERT_FALSE);
            }

        //返回失败
        return new TrashCollectResult(TrashCollectCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询医废收集
     * @param id
     * @return
     */
    @Transactional
    public TrashCollectResult findById(String id) {
        if (trashCollectDao.get(id) != null) {
            TrashCollect trashCollect = trashCollectDao.get(id);
            //返回成功
            return new TrashCollectResult(CommonCode.SUCCESS, trashCollect);
        }
        //返回失败
        return new TrashCollectResult(TrashCollectCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改医废收集
     * @param id
     * @return
     */
    @Transactional
    public TrashCollectResult edit(String id, TrashCollect trashCollect) {
        if (trashCollectDao.get(id) != null) {
            TrashCollect one = trashCollectDao.get(id);
            one.setCreateDate(trashCollect.getCreateDate());
            one.setOfficeId(trashCollect.getOfficeId());
            one.setDepartmentId(trashCollect.getDepartmentId());
            one.setCode(trashCollect.getCode());
            one.setTrashId(trashCollect.getTrashId());
            one.setPackets(trashCollect.getPackets());
            one.setCollectMethods(trashCollect.getCollectMethods());
            one.setEquipmentId(trashCollect.getEquipmentId());
            one.setCollectId(trashCollect.getCollectId());
            one.setCollectNumber(trashCollect.getCollectNumber());
            one.setViolationWeight(trashCollect.getViolationWeight());
            int update = trashCollectDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashCollectResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashCollectCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashCollectResult(TrashCollectCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除医废收集
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (trashCollectDao.get(id) != null) {
            int delete = trashCollectDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashCollectCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashCollectResult(TrashCollectCode.CMS_GET_ISNULL, null);
    }
}

