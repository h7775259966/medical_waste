package com.module.service.hospital.office;

import com.common.Response.CommonCode;
import com.common.Response.QueryResponseResult;
import com.common.Response.QueryResult;
import com.common.Response.ResponseResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.common.Exception.ExceptionCast;
import com.module.dao.hospital.department.DepartmentDao;
import com.module.dao.hospital.office.OfficeDao;
import com.module.entity.hospital.department.Department;
import com.module.entity.hospital.office.Office;
import com.common.Request.hospital.office.OfficeRequest;
import com.common.Response.hospital.office.OfficeCode;
import com.common.Response.hospital.office.OfficeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 医院科室Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class OfficeService {

	@Autowired
	private OfficeDao officeDao;

    @Autowired
    private DepartmentDao departmentDao;

    public QueryResponseResult findList(int page, int size, OfficeRequest officeRequest) {
        //为防止后面报空指针，先进行查询条件的非空判断
        if (officeRequest == null) {
            officeRequest = new OfficeRequest();
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
        //注意：如果officeRequest内参数不为空，则进行带值查询
        //officeDao.findList()为没有任何查询条件的分页查询
        List<Office> list = officeDao.findListByRequest(officeRequest);
        //通过部门id获取部门名称后一起传给前端进行展示
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Office office = list.get(i);
                if (departmentDao.get(office.getDepartmentId()) != null) {
                    Department department = departmentDao.get(office.getDepartmentId());
                    office.setDepartmentName(department.getDepartmentName());
                }else{
                    office.setDepartmentName("");
                }
            }
        }
        PageInfo<Office> pageInfo = new PageInfo<Office>(list);

        //封装结果
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 查询所有科室
     * @return
     */
    public QueryResponseResult all() {
        List<Office> list = officeDao.findList();
        //通过部门id获取部门名称后一起传给前端进行展示
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Office office = list.get(i);
                if (departmentDao.get(office.getDepartmentId()) != null) {
                    Department department = departmentDao.get(office.getDepartmentId());
                    office.setDepartmentName(department.getDepartmentName());
                }else{
                    office.setDepartmentName("");
                }
            }
        }
        PageInfo<Office> pageInfo = new PageInfo<Office>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加科室
     * @param office
     * @return
     */
    @Transactional
    public OfficeResult add(Office office) {
        if (officeDao.getByName(office.getOfficeName()) == null) {
            Office one = new Office();
            one.setOfficeId(IdGen.uuid());
            one.setDepartmentId(office.getDepartmentId());
            one.setOfficeName(office.getOfficeName());
            one.setRemarks(office.getRemarks());
            one.setCreateDate(new Date());
            int insert = officeDao.insert(one);
            if (insert > 0) {
                if (departmentDao.get(one.getDepartmentId()) != null) {
                    Department department = departmentDao.get(one.getDepartmentId());
                    one.setDepartmentName(department.getDepartmentName());
                }else{
                    one.setDepartmentName("");
                }
                //返回成功
                return new OfficeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(OfficeCode.CMS_INSERT_FALSE);
            }
        }
        //返回失败
        return new OfficeResult(OfficeCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过ID查询科室
     * @param id
     * @return
     */
    public OfficeResult findById(String id) {
        if (officeDao.get(id) != null) {
            Office office = officeDao.get(id);
            if (departmentDao.get(office.getDepartmentId()) != null) {
                Department department = departmentDao.get(office.getDepartmentId());
                office.setDepartmentName(department.getDepartmentName());
            }else{
                office.setDepartmentName("");
            }
            //返回成功
            return new OfficeResult(CommonCode.SUCCESS, office);
        }
        //返回失败
        return new OfficeResult(OfficeCode.CMS_GET_ISNULL, null);
    }

	/**
	 * 通过id修改科室
	 * @param id
	 * @return
	 */
    @Transactional
	public OfficeResult edit(String id, Office office) {
        if (officeDao.get(id) != null) {
            Office one = officeDao.get(id);
            one.setDepartmentId(office.getDepartmentId());
            one.setOfficeName(office.getOfficeName());
            one.setRemarks(office.getRemarks());
            int update = officeDao.update(one);
            if (update > 0) {
                if (departmentDao.get(one.getDepartmentId()) != null) {
                    Department department = departmentDao.get(one.getDepartmentId());
                    one.setDepartmentName(department.getDepartmentName());
                }else{
                    one.setDepartmentName("");
                }
                //返回成功
                return new OfficeResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(OfficeCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new OfficeResult(OfficeCode.CMS_GET_ISNULL, null);
	}

	/**
	 * 通过id删除科室
	 * @param id
	 * @return
	 */
    @Transactional
	public ResponseResult delete(String id) {
        if (officeDao.get(id) != null) {
            int delete = officeDao.delete(id);
            if (delete > 0) {
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(OfficeCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new OfficeResult(OfficeCode.CMS_GET_ISNULL, null);
	}


    /**
     * 通过部门id查询所属科室
     * @return
     */
    public QueryResponseResult findByDepartmentId(String departmentId) {
        List<Office> list = officeDao.findByDepartmentId(departmentId);
        //通过部门id获取部门名称后一起传给前端进行展示
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                Office office = list.get(i);
                if (departmentDao.get(office.getDepartmentId()) != null) {
                    Department department = departmentDao.get(office.getDepartmentId());
                    office.setDepartmentName(department.getDepartmentName());
                }else{
                    office.setDepartmentName("");
                }
            }
        }
        PageInfo<Office> pageInfo = new PageInfo<Office>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }
}