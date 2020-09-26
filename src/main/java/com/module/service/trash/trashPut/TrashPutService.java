package com.module.service.trash.trashPut;

import com.common.Exception.ExceptionCast;
import com.common.Request.trash.trashPut.TrashPutRequest;
import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Response.trash.trashPut.TrashPutCode;
import com.common.Response.trash.trashPut.TrashPutResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.hospital.office.OfficeDao;
import com.module.dao.trash.trashPut.TrashPutDao;
import com.module.dao.trash.trashType.TrashTypeDao;
import com.module.entity.hospital.office.Office;
import com.module.entity.trash.trashCollect.TrashCollect;
import com.module.entity.trash.trashPut.TrashPut;
import com.module.entity.trash.trashType.TrashType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医废入库Service
 * Created by huangbotao on 2020/8/31;
 */
@Service
@Transactional(readOnly = true)
public class TrashPutService {

    @Autowired
    private TrashPutDao trashPutDao;

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private TrashTypeDao trashTypeDao;


    public QueryResponseResult findListByRequest(int page, int size, TrashPutRequest trashPutRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (trashPutRequest == null) {
            trashPutRequest = new TrashPutRequest();
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

        List<TrashPut> list = trashPutDao.findListByRequest(trashPutRequest);

        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                TrashPut trashPut = list.get(i);
                if (officeDao.get(trashPut.getOfficeId()) != null) {
                    Office office = officeDao.get(trashPut.getOfficeId());
                    trashPut.setOfficeName(office.getOfficeName());
                }else{
                    trashPut.setOfficeName("");
                }
                if (trashTypeDao.get(trashPut.getTrashId()) != null) {
                    TrashType trashType = trashTypeDao.get(trashPut.getTrashId());
                    trashPut.setTrashType(trashType.getTrashType());
                }else{
                    trashPut.setTrashType("");
                }
            }
        }

        PageInfo<TrashPut> pageInfo = new PageInfo<TrashPut>(list);


        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }





    /**
     * 添加医废入库
     * @param trashPut
     * @return
     */
    @Transactional
    public TrashPutResult add(TrashPut trashPut) {
        TrashPut one = new TrashPut();
        one.setTrashPutId(IdGen.uuid());
        one.setCreateDate(new Date());
        one.setOfficeId(trashPut.getOfficeId());
        one.setDepartmentId(trashPut.getDepartmentId());
        one.setCode(trashPut.getCode());
        one.setTrashId(trashPut.getTrashId());
        one.setPackets(trashPut.getPackets());
        one.setRecycle(trashPut.getRecycle());
        one.setCollectId(trashPut.getCollectId());
        one.setCollectTime(trashPut.getCollectTime());
        one.setCollectNumber(trashPut.getCollectNumber());
        one.setCaseNum(trashPut.getCaseNum());
        one.setWeight(trashPut.getWeight());
        one.setWeightNumber(trashPut.getWeightNumber());
        one.setPutInTime(trashPut.getPutInTime());
        one.setCollectMethods(trashPut.getCollectMethods());
        int insert = trashPutDao.insert(one);
        if (insert > 0) {
            //返回成功
            return new TrashPutResult(CommonCode.SUCCESS, one);
        } else {
            //自定义异常处理
            ExceptionCast.cast(TrashPutCode.CMS_INSERT_FALSE);
        }

        //返回失败
        return new TrashPutResult(TrashPutCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询医废入库
     * @param id
     * @return
     */
    @Transactional
    public TrashPutResult findById(String id) {
        if (trashPutDao.get(id) != null) {
            TrashPut trashPut = trashPutDao.get(id);
            //返回成功
            return new TrashPutResult(CommonCode.SUCCESS, trashPut);
        }
        //返回失败
        return new TrashPutResult(TrashPutCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改医废入库
     * @param id
     * @return
     */
    @Transactional
    public TrashPutResult edit(String id, TrashPut trashPut) {
        if (trashPutDao.get(id) != null) {
            TrashPut one = trashPutDao.get(id);
            one.setCreateDate(new Date());
            one.setOfficeId(trashPut.getOfficeId());
            one.setDepartmentId(trashPut.getDepartmentId());
            one.setCode(trashPut.getCode());
            one.setTrashId(trashPut.getTrashId());
            one.setPackets(trashPut.getPackets());
            one.setRecycle(trashPut.getRecycle());
            one.setCollectId(trashPut.getCollectId());
            one.setCollectTime(trashPut.getCollectTime());
            one.setCollectNumber(trashPut.getCollectNumber());
            one.setCaseNum(trashPut.getCaseNum());
            one.setWeight(trashPut.getWeight());
            one.setWeightNumber(trashPut.getWeightNumber());
            one.setPutInTime(trashPut.getPutInTime());
            one.setCollectMethods(trashPut.getCollectMethods());
            int update = trashPutDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashPutResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashPutCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashPutResult(TrashPutCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除医废入库
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (trashPutDao.get(id) != null) {
            int delete = trashPutDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashPutCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashPutResult(TrashPutCode.CMS_GET_ISNULL, null);
    }
}

