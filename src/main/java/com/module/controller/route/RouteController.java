package com.module.controller.route;

import com.common.Request.route.RouteAndOfficeRequest;
import com.common.Response.MapResult;
import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;

import com.common.Response.route.RouteResult;
import com.module.entity.route.Route;
import com.module.service.route.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 路线Controller
 * @author hbt
 * @version 2020-09-30
 */
@RestController
@RequestMapping("/route")
public class RouteController implements RouteControllerApi {

    @Autowired
    private RouteService routeService;


    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size) {

        return routeService.findList(page,size);
    }

    /**
     * 查询所有路线
     * @param
     * @return
     */
    @Override
    @GetMapping("/all")
    public QueryResponseResult all() {

        return routeService.all();
    }

    /**
     * 添加路线
     * @param route
     * @return
     */
    @Override
    @PostMapping("/add")
    public RouteResult add(@RequestBody Route route) {

        return routeService.add(route);
    }

    /**
     * 通过id查询路线
     * (同时查询出此路线下分配的科室)
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public MapResult findById(@PathVariable("id") String id) {

        return routeService.findById(id);
    }

    /**
     * 通过id修改路线
     * @param id
     * @param route
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public RouteResult edit(@PathVariable("id") String id, @RequestBody Route route) {

        return routeService.edit(id,route);
    }

    /**
     * 通过id删除路线
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return routeService.delete(id);
    }

    /**
     * 给线路分配科室
     * @param routeAndOfficeRequest
     * @return
     */
    @Override
    @PostMapping("/assignPrem")
    public ResponseResult assignPrem(@RequestBody RouteAndOfficeRequest routeAndOfficeRequest) {

        return routeService.assignPrem(routeAndOfficeRequest);
    }
}