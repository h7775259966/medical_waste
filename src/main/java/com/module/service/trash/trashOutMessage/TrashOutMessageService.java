package com.module.service.trash.trashOutMessage;

import com.common.Exception.ExceptionCast;
import com.common.Request.trash.trashOutMessage.TrashOutMessageRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Response.trash.trashOutMessage.TrashOutMessageCode;
import com.common.Response.trash.trashOutMessage.TrashOutMessageResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.trash.trashOutMessage.TrashOutMessageDao;
import com.module.entity.trash.trashOutMessage.TrashOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 出库转运信息Service
 * @author zx
 * @version 2020-10-12
 */
@Service
@Transactional(readOnly = true)
public class TrashOutMessageService {

    @Autowired
    private TrashOutMessageDao trashOutMessageDao;


    public QueryResponseResult findList(int page, int size, TrashOutMessageRequest trashOutMessageRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashOutMessageRequest == null) {
            trashOutMessageRequest = new TrashOutMessageRequest();
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
        List<TrashOutMessage> list = trashOutMessageDao.findListByRequest(trashOutMessageRequest);
        PageInfo<TrashOutMessage> pageInfo = new PageInfo<TrashOutMessage>(list);
        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }



    /**
     * 添加出库转运信息
     * @param trashOutMessage
     * @return
     */
    @Transactional
    public TrashOutMessageResult add(TrashOutMessage trashOutMessage) {
        TrashOutMessage one = new TrashOutMessage();
        one.setId(IdGen.uuid());
        one.setType(trashOutMessage.getType());
        one.setContent(trashOutMessage.getContent());
        one.setRemarks(trashOutMessage.getRemarks());
        one.setCreateDate(trashOutMessage.getCreateDate());
        int insert = trashOutMessageDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new TrashOutMessageResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(TrashOutMessageCode.CMS_INSERT_FALSE);
        }

        //返回失败
        return new TrashOutMessageResult(TrashOutMessageCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询出库转运信息
     * @param id
     * @return
     */
    @Transactional
    public TrashOutMessageResult findById(String id) {
        if (trashOutMessageDao.get(id) != null) {
            TrashOutMessage trashOutMessage = trashOutMessageDao.get(id);
            //返回成功
            return new TrashOutMessageResult(CommonCode.SUCCESS, trashOutMessage);
        }
        //返回失败
        return new TrashOutMessageResult(TrashOutMessageCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改出库转运信息
     * @param id
     * @return
     */
    @Transactional
    public TrashOutMessageResult edit(String id, TrashOutMessage trashOutMessage) {
        if (trashOutMessageDao.get(id) != null) {
            TrashOutMessage one = trashOutMessageDao.get(id);
            one.setType(trashOutMessage.getType());
            one.setContent(trashOutMessage.getContent());
            one.setRemarks(trashOutMessage.getRemarks());
            int update = trashOutMessageDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashOutMessageResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutMessageCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashOutMessageResult(TrashOutMessageCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除出库转运信息
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (trashOutMessageDao.get(id) != null) {
            int delete = trashOutMessageDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashOutMessageCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashOutMessageResult(TrashOutMessageCode.CMS_GET_ISNULL, null);
    }
}

