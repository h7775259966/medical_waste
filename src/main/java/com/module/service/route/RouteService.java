package com.module.service.route;

import com.common.Exception.ExceptionCast;
import com.common.Request.route.RouteAndOfficeRequest;
import com.common.Response.*;
import com.common.Response.route.RouteCode;
import com.common.Response.route.RouteResult;
import com.common.Utils.IdGen;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.module.dao.hospital.office.OfficeDao;
import com.module.dao.route.RouteAndOfficeDao;
import com.module.dao.route.RouteDao;
import com.module.entity.hospital.office.Office;
import com.module.entity.route.Route;
import com.module.entity.route.RouteAndOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 *路线Service
 * @author zx
 * @version 2020-08-24
 */
@Service
@Transactional(readOnly = true)
public class RouteService {

    @Autowired
    private RouteDao routeDao;

    @Autowired
    private OfficeDao officeDao;

    @Autowired
    private RouteAndOfficeDao routeAndOfficeDao;

    @Autowired
    private com.module.service.hospital.office.OfficeService OfficeService;


    public QueryResponseResult findList(int page, int size) {
        //为防止后面报空指针，先进行查询条件的非空判断
        //分页参数处理
        if (page <= 0) {
            page = 1;
        }
        if (size <= 0) {
            size = 10;
        }
        //分页处理
        PageHelper.startPage(page,size);
        List<Route> list = routeDao.findList();
        PageInfo<Route> pageInfo = new PageInfo<Route>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 查询所有路线
     * @return
     */
    public QueryResponseResult all() {
        List<Route> list = routeDao.findList();
        PageInfo<Route> pageInfo = new PageInfo<Route>(list);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(list);//数据列表
        queryResult.setTotal(pageInfo.getTotal());//数据总记录数
        QueryResponseResult queryResponseResult = new QueryResponseResult(CommonCode.SUCCESS, queryResult);
        return queryResponseResult;
    }

    /**
     * 添加路线
     * @param route
     * @return
     */
    @Transactional
    public RouteResult add(Route route) {
            Route one = new Route();
            one.setLineConfigId(IdGen.uuid());
            one.setCollectId(route.getCollectId());
            one.setEquipmentNum(route.getEquipmentNum());
            one.setConfig(route.getConfig());
            one.setRouteName(route.getRouteName());
            one.setCreateDate(new Date());
            int insert = routeDao.insert(one);
            if (insert > 0) {
                //返回成功
                return new RouteResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RouteCode.CMS_INSERT_FALSE);
            }
        
        //返回失败
        return new RouteResult(RouteCode.CMS_NAME_REPETITION, null);
    }

    /**
     * 通过id查询路线
     * (同时查询出此路线下分配的科室)
     * @param id
     * @return
     */
   public MapResult findById(String id) {
        if (routeDao.get(id) != null) {
            Map<String,Object> map = new HashMap<>();
            Route route = routeDao.get(id);
            map.put("route",route);
            List<Office> OfficeAllList = findOfficeAllByRouteId(id);
            if(OfficeAllList.size()>0){
                map.put("OfficeAllList",OfficeAllList);
            }
            //返回成功
            return new MapResult(CommonCode.SUCCESS, map);
        }
        //返回失败
        return new MapResult(RouteCode.CMS_GET_ISNULL, null);
    }

    /**
     * 根据路线id查询对应的所有科室
     * @param id
     * @return
     */


    public List<Office> findOfficeAllByRouteId(String id){
        List<RouteAndOffice> list = routeAndOfficeDao.getByRouteId(id);
        List<Office> OfficeAllList = new ArrayList<Office>();
        if(list.size()>0){
            for (int i = 0; i <list.size(); i++) {
                RouteAndOffice routeAndOffice = list.get(i);
            /*    if (OfficeService.findById(routeAndOffice.getOfficeId())!=null){
                    Office OfficeAll = OfficeService.findById(routeAndOffice.getOfficeId());
                    OfficeAllList.add(OfficeAll);
                }*/
            }
        }
        return  OfficeAllList;
    }



    /**
     * 通过id修改路线
     * @param id
     * @return
     */
    @Transactional
    public RouteResult edit(String id, Route route) {
        if (routeDao.get(id) != null) {
            Route one = routeDao.get(id);
            one.setCollectId(route.getCollectId());
            one.setEquipmentNum(route.getEquipmentNum());
            one.setConfig(route.getConfig());
            one.setRouteName(route.getRouteName());
            one.setCreateDate(new Date());
            int update = routeDao.update(one);
            if (update > 0) {
                //返回成功
                return new RouteResult(CommonCode.SUCCESS, one);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RouteCode.CMS_UPDATE_FALSE);
            }
        }
        //返回失败
        return new RouteResult(RouteCode.CMS_GET_ISNULL, null);
    }

    /**
     * 通过id删除路线
     * @param id
     * @return
     */
    @Transactional
    public ResponseResult delete(String id) {
        if (routeDao.get(id) != null) {
            int delete = routeDao.delete(id);
            if (delete > 0) {
                routeAndOfficeDao.deleteByRouteId(id);
                //返回成功
                return new ResponseResult(CommonCode.SUCCESS);
            } else {
                //自定义异常处理
                ExceptionCast.cast(RouteCode.CMS_DELETE_FALSE);
            }
        }
        //返回失败
        return new RouteResult(RouteCode.CMS_GET_ISNULL, null);
    }

    /**
     * 给路线添加权限
     * @param routeAndOfficeRequest
     * @return
     */

    @Transactional
    public ResponseResult assignPrem(RouteAndOfficeRequest routeAndOfficeRequest) {
        if (routeDao.get(routeAndOfficeRequest.getRouteId()) != null) {
            List<String> OfficeList = routeAndOfficeRequest.getOfficeId();
            if (OfficeList.size()>0) {
                //分配路线前，先将中间表旧数据删除
                routeAndOfficeDao.deleteByRouteId(routeAndOfficeRequest.getRouteId());
                List<Office> perms = new ArrayList<Office>();
                for (int i = 0; i < OfficeList.size(); i++) {
                    Office office = officeDao.get(OfficeList.get(i));
                    perms.add(office);//当前菜单或按钮的权限
                    //需要根据父id和类型查询API权限列表
//                    List<Office> apiList = officeDao.findByTypeAndPid(OfficeConstants.PERMISSION_API, OfficeList.get(i));
//                    if (apiList.size()>0) {
//                        perms.addAll(apiList);//pid等于这个权限id的API权限
//                    }
                }
                for (int k = 0; k <perms.size(); k++) {
                    Office office2 = perms.get(k);
                    RouteAndOffice routeAndOffice = new RouteAndOffice();
                    routeAndOffice.setId(IdGen.uuid());
                    routeAndOffice.setXaxis(routeAndOffice.getXaxis());
                    routeAndOffice.setYaxis(routeAndOffice.getYaxis());
                    routeAndOffice.setOfficeName(routeAndOffice.getOfficeName());
                    routeAndOfficeDao.insert(routeAndOffice);
                }
                return new ResponseResult(CommonCode.SUCCESS);
            }
        }
        //返回失败
        return new ResponseResult(RouteCode.CMS_ASSIGNROLES_FALSE);
    }


}