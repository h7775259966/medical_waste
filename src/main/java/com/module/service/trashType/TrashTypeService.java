package com.module.service.trashType;

import com.common.Response.CommonCode;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.module.config.exception.ExceptionCast;
import com.module.dao.trashType.TrashTypeDao;
import com.module.entity.trashType.TrashType;
import com.module.response.trashType.TrashTypeCode;
import com.module.response.trashType.TrashTypeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;

/**
 * 医院医废类型Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class TrashTypeService {

	@Autowired
	private TrashTypeDao trashTypeDao;

    /**
     * 添加医废类型
     * @param trashType
     * @return
     */
    @Transactional
    public TrashTypeResult add(TrashType trashType) {
        if (trashTypeDao.getByName(trashType.getTrashType()) == null) {
            TrashType one = new TrashType();
            one.setTrashId(IdGen.uuid());
            one.setTrashType(trashType.getTrashType());
            one.setRemarks(trashType.getRemarks());
            one.setCreateDate(new Date());
            int insert = trashTypeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new TrashTypeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashTypeCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new TrashTypeResult(TrashTypeCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询医废类型
     * @param id
     * @return
     */
    public TrashTypeResult findById(String id) {
        if (trashTypeDao.get(id) != null) {
            TrashType trashType = trashTypeDao.get(id);
            //返回成功
            return new TrashTypeResult(CommonCode.SUCCESS, trashType);
        }
        //返回失败
        return new TrashTypeResult(TrashTypeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改医废类型
	 * @param id
	 * @return
	 */
    @Transactional
	public TrashTypeResult edit(String id, TrashType trashType) {
        if (trashTypeDao.get(id) != null) {
            TrashType one = trashTypeDao.get(id);
            one.setTrashType(trashType.getTrashType());
            one.setRemarks(trashType.getRemarks());
            int update = trashTypeDao.update(one);
            if (update > 0) {
                //返回成功
                return new TrashTypeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashTypeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new TrashTypeResult(TrashTypeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除医废类型
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (trashTypeDao.get(id) != null) {
            int delete = trashTypeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(TrashTypeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new TrashTypeResult(TrashTypeCode.CMS_GET_ISNULL, null);
	}

}