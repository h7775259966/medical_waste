package com.module.service.trash.trashOut;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.trash.trashOut.TrashOutDao;
import com.module.entity.trash.trashOut.TrashOut;
import com.common.Request.trash.trashOut.TrashOutRequest;
import com.common.Response.trash.trashOut.TrashOutCode;
import com.common.Response.trash.trashOut.TrashOutResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医废出库Service
 * Created by huangbotao on 2020/8/31;
 */
@Service
@Transactional(readOnly = true)
public class TrashOutService {

    @Autowired
    private TrashOutDao trashOutDao;


    public QueryResponseResult findList(int page, int size, TrashOutRequest trashOutRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashOutRequest == null) {
            trashOutRequest = new TrashOutRequest();
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
        List<TrashOut> list = trashOutDao.findList(trashOutRequest);
        PageInfo<TrashOut> pageInfo = new PageInfo<TrashOut>(list);

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }



    /**
     * 添加出库操作
     * @param trashOut
     * @return
     */
    @Transactional
    public TrashOutResult add(TrashOut trashOut) {
        TrashOut one = new TrashOut();
        one.setTrashOutId(IdGen.uuid());
        one.setCreateDate(trashOut.getCreateDate());
        one.setCollectTime(trashOut.getCollectTime());
        one.setStatus(trashOut.getStatus());
        one.setCollectWeight(trashOut.getCollectWeight());
        one.setPutWeight(trashOut.getPutWeight());
        one.setOutWeight(trashOut.getOutWeight());
        one.setOutDetail(trashOut.getOutDetail());
        int insert = trashOutDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new TrashOutResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(TrashOutCode.CMS_INSERT_FALSE);
        }

        //返回失败
        return new TrashOutResult(TrashOutCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询出库操作
     * @param id
     * @return
     */
    @Transactional
    public TrashOutResult findById(String id) {
        if (trashOutDao.get(id) != null) {
            TrashOut trashOut = trashOutDao.get(id);
            //返回成功
            return new TrashOutResult(CommonCode.SUCCESS, trashOut);
        }
        //返回失败
        return new TrashOutResult(TrashOutCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改出库操作
     * @param id
     * @return
     */
    @Transactional
    public TrashOutResult edit(String id, TrashOut trashOut) {
        if (trashOutDao.get(id) != null) {
            TrashOut one = trashOutDao.get(id);
            one.setCreateDate(trashOut.getCreateDate());
            one.setCollectTime(trashOut.getCollectTime());
            one.setStatus(trashOut.getStatus());
            one.setCollectWeight(trashOut.getCollectWeight());
            one.setPutWeight(trashOut.getPutWeight());
            one.setOutWeight(trashOut.getOutWeight());
            one.setOutDetail(trashOut.getOutDetail());
            int update = trashOutDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashOutResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashOutResult(TrashOutCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除出库操作
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (trashOutDao.get(id) != null) {
            int delete = trashOutDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashOutResult(TrashOutCode.CMS_GET_ISNULL, null);
    }


    /**
     * 通过id修改发布状态
     * @param id
     * @return
     */
    @Transactional
    public TrashOutResult editStatus(String id, Integer status) {
        if (trashOutDao.get(id) != null && status != null) {
            TrashOut one = trashOutDao.get(id);
            one.setStatus(status);
            if(status==2){//发布状态 1为未发布,2为已发布
                one.setCreateDate(new Date());
            }
            if(status==1){
                one.setStatus(2);
            }
            int update = trashOutDao.editStatus(one);
            if (update > 0) {
                //返回成功
                return new TrashOutResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutCode.CMS_EDITSTATUS_FALSE);
            }
        }
        //返回失败
        return new TrashOutResult(TrashOutCode.CMS_GET_ISNULL, null);
    }




}

