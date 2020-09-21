package com.module.service.trash.TrashOutHistory;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.trash.trashOutHistory.TrashOutHistoryDao;
import com.module.entity.trash.trashOutHistory.TrashOutHistory;
import com.module.request.trash.trashOutHistory.TrashOutHistoryRequest;
import com.module.response.trash.trashOutHistory.TrashOutHistoryCode;
import com.module.response.trash.trashOutHistory.TrashOutHistoryResult;
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
public class TrashOutHistoryService {

    @Autowired
    private TrashOutHistoryDao trashOutHistoryDao;


    public QueryResponseResult findList(int page, int size, TrashOutHistoryRequest trashOutHistoryRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashOutHistoryRequest == null) {
            trashOutHistoryRequest = new TrashOutHistoryRequest();
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
        List<TrashOutHistory> list = trashOutHistoryDao.findList();
        PageInfo<TrashOutHistory> pageInfo = new PageInfo<TrashOutHistory>(list);

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
     * 添加出库操作
     * @param trashOutHistory
     * @return
     */
    @Transactional
    public TrashOutHistoryResult add(TrashOutHistory trashOutHistory) {
        TrashOutHistory one = new TrashOutHistory();
        one.setTrashOutHistoryId(IdGen.uuid());
        one.setCreateDate(trashOutHistory.getCreateDate());
        one.setOutTime(trashOutHistory.getOutTime());
        one.setPerson(trashOutHistory.getPerson());
        one.setOutWeight(trashOutHistory.getOutWeight());
        one.setCaseNum(trashOutHistory.getCaseNum());
        one.setOutCompany(trashOutHistory.getOutCompany());
        one.setCarNumber(trashOutHistory.getCarNumber());
        one.setCarry(trashOutHistory.getCarry());
        one.setAccessory(trashOutHistory.getAccessory());
        one.setOutDetail(trashOutHistory.getOutDetail());
        int insert = trashOutHistoryDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new TrashOutHistoryResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(TrashOutHistoryCode.CMS_INSERT_FALSE);
        }

        //返回失败
        return new TrashOutHistoryResult(TrashOutHistoryCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询出库操作
     * @param id
     * @return
     */
    @Transactional
    public TrashOutHistoryResult findById(String id) {
        if (trashOutHistoryDao.get(id) != null) {
            TrashOutHistory trashOutHistory = trashOutHistoryDao.get(id);
            //返回成功
            return new TrashOutHistoryResult(CommonCode.SUCCESS, trashOutHistory);
        }
        //返回失败
        return new TrashOutHistoryResult(TrashOutHistoryCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改出库操作
     * @param id
     * @return
     */
    @Transactional
    public TrashOutHistoryResult edit(String id, TrashOutHistory trashOutHistory) {
        if (trashOutHistoryDao.get(id) != null) {
            TrashOutHistory one = trashOutHistoryDao.get(id);
            one.setCreateDate(new Date());
            one.setOutTime(trashOutHistory.getOutTime());
            one.setPerson(trashOutHistory.getPerson());
            one.setOutWeight(trashOutHistory.getOutWeight());
            one.setCaseNum(trashOutHistory.getCaseNum());
            one.setOutCompany(trashOutHistory.getOutCompany());
            one.setCarNumber(trashOutHistory.getCarNumber());
            one.setCarry(trashOutHistory.getCarry());
            one.setAccessory(trashOutHistory.getAccessory());
            one.setOutDetail(trashOutHistory.getOutDetail());
            int update = trashOutHistoryDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashOutHistoryResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutHistoryCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashOutHistoryResult(TrashOutHistoryCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除出库操作
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (trashOutHistoryDao.get(id) != null) {
            int delete = trashOutHistoryDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutHistoryCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashOutHistoryResult(TrashOutHistoryCode.CMS_GET_ISNULL, null);
    }
}

