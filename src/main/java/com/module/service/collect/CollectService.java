package com.module.service.collect;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.collect.CollectDao;
import com.module.dao.hospital.hospital.HospitalDao;
import com.module.entity.collect.Collect;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.hospital.Hospital;
import com.module.entity.hospital.office.Office;
import com.module.request.collect.CollectRequest;
import com.module.response.collect.CollectCode;
import com.module.response.collect.CollectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 收集人Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class CollectService {

	@Autowired
	private CollectDao collectDao;

    @Autowired
    private HospitalDao hospitalDao;

    public QueryResponseResult findList(int page, int size, CollectRequest collectRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (collectRequest == null) {
            collectRequest = new CollectRequest();
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
        List<Collect> list = collectDao.findListByRequest(collectRequest);
        //通过医院id获取医院名称后一起传给前端进行展示
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Collect collect = list.get(i);
                if (hospitalDao.get(collect.getHospitalId()) != null) {
                    Hospital hospital = hospitalDao.get(collect.getHospitalId());
                    collect.setHospitalName(hospital.getHospitalName());
                }else{
                    collect.setHospitalName("");
                }
            }
        }
        PageInfo<Collect> pageInfo = new PageInfo<Collect>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;

    }

    /**
     * 添加收集人
     * @param collect
     * @return
     */
    @Transactional
    public CollectResult add(Collect collect) {
            Collect one = new Collect();
            one.setCollectId(IdGen.uuid());
            one.setCollectName(collect.getCollectName());
            one.setCollectCode(collect.getCollectCode());
            one.setHospitalId(collect.getHospitalId());
            one.setRemarks(collect.getRemarks());
            one.setCreateDate(new Date());
            int insert = collectDao.insert(one);
            if (insert > 0) {
                if (hospitalDao.get(one.getHospitalId()) != null) {
                    Hospital hospital = hospitalDao.get(one.getHospitalId());
                    one.setHospitalName(hospital.getHospitalName());
                }else{
                    one.setHospitalName("");
                }
                //返回成功
                return new CollectResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CollectCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new CollectResult(CollectCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询收集人
     * @param id
     * @return
     */
    public CollectResult findById(String id) {
        if (collectDao.get(id) != null) {
            Collect collect = collectDao.get(id);
            if (hospitalDao.get(collect.getHospitalId()) != null) {
                Hospital hospital = hospitalDao.get(collect.getHospitalId());
                collect.setHospitalName(hospital.getHospitalName());
            }else{
                collect.setHospitalName("");
            }
            //返回成功
            return new CollectResult(CommonCode.SUCCESS, collect);
        }
        //返回失败
        return new CollectResult(CollectCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改收集人
	 * @param id
	 * @return
	 */
    @Transactional
	public CollectResult edit(String id, Collect collect) {
        if (collectDao.get(id) != null) {
            Collect one = collectDao.get(id);
            one.setCollectName(collect.getCollectName());
            one.setRemarks(collect.getRemarks());
            one.setCollectCode(collect.getCollectCode());
            one.setHospitalId(collect.getHospitalId());
            int update = collectDao.update(one);
            if (update > 0) {
                if (hospitalDao.get(one.getHospitalId()) != null) {
                    Hospital hospital = hospitalDao.get(one.getHospitalId());
                    one.setHospitalName(hospital.getHospitalName());
                }else{
                    one.setHospitalName("");
                }
                //返回成功
                return new CollectResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CollectCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new CollectResult(CollectCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除收集人
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (collectDao.get(id) != null) {
            int delete = collectDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(CollectCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new CollectResult(CollectCode.CMS_GET_ISNULL, null);
	}

}