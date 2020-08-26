package com.module.service.nurse;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.config.exception.ExceptionCast;
import com.module.dao.nurse.NurseDao;
import com.module.entity.nurse.Nurse;
import com.module.request.nurse.NurseRequest;
import com.module.response.nurse.NurseCode;
import com.module.response.nurse.NurseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医院护士Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class NurseService {

	@Autowired
	private NurseDao nurseDao;

    public QueryResponseResult findList(int page, int size, NurseRequest nurseRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (nurseRequest == null) {
            nurseRequest = new NurseRequest();
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
        //注意：如果nurseRequest内参数不为空，则进行带值查询
        //nurseDao.findList()为没有任何查询条件的分页查询
        List<Nurse> list = nurseDao.findList();
        PageInfo<Nurse> pageInfo = new PageInfo<Nurse>(list);

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
     * 添加护士
     * @param nurse
     * @return
     */
    @Transactional
    public NurseResult add(Nurse nurse) {
            Nurse one = new Nurse();
            one.setNurseId(IdGen.uuid());
            one.setNurseName(nurse.getNurseName());
            one.setNurseCode(nurse.getNurseCode());
            one.setDepartmentId(nurse.getDepartmentId());
            one.setOfficeId(nurse.getOfficeId());
            one.setRemarks(nurse.getRemarks());
            one.setCreateDate(new Date());
            int insert = nurseDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new NurseResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NurseCode.CMS_INSERT_FALSE);
            }
        //返回失败
        return new NurseResult(NurseCode.CMS_INSERT_FALSE, null);
    }

    /**
     * 通过ID查询护士
     * @param id
     * @return
     */
    public NurseResult findById(String id) {
        if (nurseDao.get(id) != null) {
            Nurse nurse = nurseDao.get(id);
            //返回成功
            return new NurseResult(CommonCode.SUCCESS, nurse);
        }
        //返回失败
        return new NurseResult(NurseCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改护士
	 * @param id
	 * @return
	 */
    @Transactional
	public NurseResult edit(String id, Nurse nurse) {
        if (nurseDao.get(id) != null) {
            Nurse one = nurseDao.get(id);
            one.setNurseName(nurse.getNurseName());
            one.setRemarks(nurse.getRemarks());
            one.setNurseCode(nurse.getNurseCode());
            one.setDepartmentId(nurse.getDepartmentId());
            one.setOfficeId(nurse.getOfficeId());
            int update = nurseDao.update(one);
            if (update > 0) {
                //返回成功
                return new NurseResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NurseCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new NurseResult(NurseCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除护士
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (nurseDao.get(id) != null) {
            int delete = nurseDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(NurseCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new NurseResult(NurseCode.CMS_GET_ISNULL, null);
	}

}