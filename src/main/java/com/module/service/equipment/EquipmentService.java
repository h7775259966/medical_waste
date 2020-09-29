package com.module.service.equipment;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.equipment.EquipmentDao;
import com.module.entity.equipment.Equipment;
import com.common.Request.equipment.EquipmentRequest;
import com.common.Response.equipment.EquipmentCode;
import com.common.Response.equipment.EquipmentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 设备Service
 * @author hbt
 * @version 2020-09-03
 */



@Service
@Transactional(readOnly = true)
public class EquipmentService {

    @Autowired
    private EquipmentDao equipmentDao;


    public QueryResponseResult findList(int page, int size, EquipmentRequest equipmentRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
            if (equipmentRequest == null) {
                equipmentRequest = new EquipmentRequest();
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
            List<Equipment> list = equipmentDao.findListByRequest(equipmentRequest);
            PageInfo<Equipment> pageInfo = new PageInfo<Equipment>(list);
            //封装结果
            QueryResult queryResult = new QueryResult();
            queryResult.setList(list);//数据列表
            queryResult.setTotal(pageInfo.getTotal());//数据总记录数
            QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
            return queryResponseResult;

        }


    /**
     * 添加设备
     * @param equipment
     * @return
     */
    @Transactional
    public EquipmentResult add(Equipment equipment) {
        if (equipmentDao.getByName(equipment.getEquipmentName()) == null) {
            Equipment one = new Equipment();
            one.setEquipmentName(equipment.getEquipmentName());
            one.setEquipmentId(IdGen.uuid());
            one.setEquipmentNum(equipment.getEquipmentNum());
            one.setEquipmentSIM(equipment.getEquipmentSIM());
            one.setEquipmentFirm(equipment.getEquipmentFirm());
            one.setHospitalId(equipment.getHospitalId());
            one.setRemarks(equipment.getRemarks());
            one.setStatus(equipment.getStatus());
            one.setCreateDate(equipment.getCreateDate());
            int insert = equipmentDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new EquipmentResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(EquipmentCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new EquipmentResult(EquipmentCode.CMS_NAME_REPETITION, null);
    }


    /**
     * 通过ID查询设备
     * @param id
     * @return
     */
    @Transactional
    public EquipmentResult findById(String id) {
        if (equipmentDao.get(id) != null) {
            Equipment equipment = equipmentDao.get(id);
            //返回成功
            return new EquipmentResult(CommonCode.SUCCESS, equipment);
        }
        //返回失败
        return new EquipmentResult(EquipmentCode.CMS_GET_ISNULL, null);
    }



    /**
     * 通过id修改设备
     * @param id
     * @return
     */
    @Transactional
    public EquipmentResult edit(String id, Equipment equipment) {
        if (equipmentDao.get(id) != null) {
            Equipment one = equipmentDao.get(id);
            one.setEquipmentName(equipment.getEquipmentName());
            one.setEquipmentNum(equipment.getEquipmentNum());
            one.setEquipmentSIM(equipment.getEquipmentSIM());
            one.setEquipmentFirm(equipment.getEquipmentFirm());
            one.setHospitalId(equipment.getHospitalId());
            one.setRemarks(equipment.getRemarks());
            one.setStatus(equipment.getStatus());
            one.setCreateDate(equipment.getCreateDate());
            int update = equipmentDao.update(one);
            if (update > 0) {
                //返回成功
                return new EquipmentResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(EquipmentCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new EquipmentResult(EquipmentCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除设备
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (equipmentDao.get(id) != null) {
            int delete = equipmentDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(EquipmentCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new EquipmentResult(EquipmentCode.CMS_GET_ISNULL, null);
    }
}
