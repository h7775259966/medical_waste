package com.module.service.hospital;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.hospital.HospitalDao;
import com.module.entity.hospital.Hospital;
import com.module.request.hospital.HospitalRequest;
import com.module.response.hospital.HospitalCode;
import com.module.response.hospital.HospitalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医院Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

    public QueryResponseResult findList(int page, int size, HospitalRequest hospitalRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (hospitalRequest == null) {
            hospitalRequest = new HospitalRequest();
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
        //注意：如果hospitalRequest内参数不为空，则进行带值查询
        //hospitalDao.findList()为没有任何查询条件的分页查询
        List<Hospital> list = hospitalDao.findListByRequest(hospitalRequest);
        PageInfo<Hospital> pageInfo = new PageInfo<Hospital>(list);

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
     * 添加医院
     * @param hospital
     * @return
     */
    @Transactional
    public HospitalResult add(Hospital hospital) {
        if (hospitalDao.getByName(hospital.getHospitalName()) == null) {
            Hospital one = new Hospital();
            one.setHospitalId(IdGen.uuid());
            one.setHospitalName(hospital.getHospitalName());
            one.setHospitalNumber(hospital.getHospitalNumber());
            one.setAverageTrash(hospital.getAverageTrash());
            one.setBedNumber(hospital.getBedNumber());
            one.setGrade(hospital.getGrade());
            one.setHospitalContent(hospital.getHospitalContent());
            one.setOfficeNumber(hospital.getOfficeNumber());
            one.setPrincipal(hospital.getPrincipal());
            one.setProcessingMode(hospital.getProcessingMode());
            one.setPicture(hospital.getPicture());
            one.setRemarks(hospital.getRemarks());
            one.setCreateDate(new Date());
            int insert = hospitalDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new HospitalResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(HospitalCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new HospitalResult(HospitalCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询医院
     * @param id
     * @return
     */
    public HospitalResult findById(String id) {
        if (hospitalDao.get(id) != null) {
            Hospital hospital = hospitalDao.get(id);
            //返回成功
            return new HospitalResult(CommonCode.SUCCESS, hospital);
        }
        //返回失败
        return new HospitalResult(HospitalCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改医院
	 * @param id
	 * @return
	 */
    @Transactional
	public HospitalResult edit(String id, Hospital hospital) {
        if (hospitalDao.get(id) != null) {
            Hospital one = hospitalDao.get(id);
            one.setHospitalName(hospital.getHospitalName());
            one.setHospitalNumber(hospital.getHospitalNumber());
            one.setAverageTrash(hospital.getAverageTrash());
            one.setBedNumber(hospital.getBedNumber());
            one.setGrade(hospital.getGrade());
            one.setHospitalContent(hospital.getHospitalContent());
            one.setOfficeNumber(hospital.getOfficeNumber());
            one.setPrincipal(hospital.getPrincipal());
            one.setProcessingMode(hospital.getProcessingMode());
            one.setPicture(hospital.getPicture());
            one.setRemarks(hospital.getRemarks());
            one.setCreateDate(new Date());
            int update = hospitalDao.update(one);
            if (update > 0) {
                //返回成功
                return new HospitalResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(HospitalCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new HospitalResult(HospitalCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除医院
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (hospitalDao.get(id) != null) {
            int delete = hospitalDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(HospitalCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new HospitalResult(HospitalCode.CMS_GET_ISNULL, null);
	}

}