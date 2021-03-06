package com.module.service.hospital.nurse;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.hospital.department.DepartmentDao;
import com.module.dao.hospital.nurse.NurseDao;
import com.module.dao.hospital.office.OfficeDao;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.nurse.Nurse;
import com.module.entity.hospital.office.Office;
import com.common.Request.hospital.nurse.NurseRequest;
import com.common.Response.hospital.nurse.NurseCode;
import com.common.Response.hospital.nurse.NurseResult;
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

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private OfficeDao officeDao;

    public QueryResponseResult findList(int page, int size, NurseRequest nurseRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (nurseRequest == null) {
            nurseRequest = new NurseRequest();
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
        List<Nurse> list = nurseDao.findListByRequest(nurseRequest);
        //通过部门id和科室id获取部门科室名称后一起传给前端进行展示
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Nurse nurse = list.get(i);
                if (departmentDao.get(nurse.getDepartmentId()) != null) {
                    Department department = departmentDao.get(nurse.getDepartmentId());
                    nurse.setDepartmentName(department.getDepartmentName());
                }else{
                    nurse.setDepartmentName("");
                }
                if (officeDao.get(nurse.getOfficeId()) != null) {
                    Office office = officeDao.get(nurse.getOfficeId());
                    nurse.setOfficeName(office.getOfficeName());
                }else{
                    nurse.setOfficeName("");
                }
            }
        }
        PageInfo<Nurse> pageInfo = new PageInfo<Nurse>(list);
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
                if (departmentDao.get(one.getDepartmentId()) != null) {
                    Department department = departmentDao.get(one.getDepartmentId());
                    one.setDepartmentName(department.getDepartmentName());
                }else{
                    one.setDepartmentName("");
                }
                if (officeDao.get(one.getOfficeId()) != null) {
                    Office office = officeDao.get(one.getOfficeId());
                    one.setOfficeName(office.getOfficeName());
                }else{
                    one.setOfficeName("");
                }
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
            if (departmentDao.get(nurse.getDepartmentId()) != null) {
                Department department = departmentDao.get(nurse.getDepartmentId());
                nurse.setDepartmentName(department.getDepartmentName());
            }else{
                nurse.setDepartmentName("");
            }
            if (officeDao.get(nurse.getOfficeId()) != null) {
                Office office = officeDao.get(nurse.getOfficeId());
                nurse.setOfficeName(office.getOfficeName());
            }else{
                nurse.setOfficeName("");
            }
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
                if (departmentDao.get(one.getDepartmentId()) != null) {
                    Department department = departmentDao.get(one.getDepartmentId());
                    one.setDepartmentName(department.getDepartmentName());
                }else{
                    one.setDepartmentName("");
                }
                if (officeDao.get(one.getOfficeId()) != null) {
                    Office office = officeDao.get(one.getOfficeId());
                    one.setOfficeName(office.getOfficeName());
                }else{
                    one.setOfficeName("");
                }
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