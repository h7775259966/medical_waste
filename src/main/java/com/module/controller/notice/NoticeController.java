package com.module.controller.notice;

import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.notice.Notice;
import com.module.request.notice.NoticeRequest;
import com.module.response.notice.NoticeResult;
import com.module.service.notice.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 公告Controller
 * @author hbt
 * @version 2020-09-03
 */

@RestController
@RequestMapping("/notice")
public class NoticeController implements NoticeControllerApi {

    @Autowired
    private NoticeService noticeService;


    /**
     * 分页同时自定义查询
     * @param page
     * @param size
     * @param noticeRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")int size, NoticeRequest noticeRequest) {

        return noticeService.findList(page,size, noticeRequest);
    }

    /**
     * 通过id查询公告
     * @param id
     * @return
     */
    @Override
    @GetMapping("/get/{id}")
    public NoticeResult findById(@PathVariable("id") String id) {

        return noticeService.findById(id);
    }

    @Override
    @GetMapping("/search/{page}/{size}")
    public QueryResponseResult search(@PathVariable("page") int page, @PathVariable("size")int size, NoticeRequest noticeRequest) {
        return noticeService.search(page,size, noticeRequest);
    }


    /**
     * 添加公告
     * @param notice
     * @return
     */
    @Override
    @PostMapping("/add")
    public NoticeResult add(@RequestBody Notice notice) {

        return noticeService.add(notice);
    }

    /**
     * 通过id修改公告
     * @param id
     * @param notice
     * @return
     */
    @Override
    @PutMapping("/edit/{id}")//这里使用put方法，http 方法中put表示更新
    public NoticeResult edit(@PathVariable("id") String id, @RequestBody Notice notice) {

        return noticeService.edit(id,notice);
    }

    /**
     * 通过id删除公告
     * @param id
     * @return
     */
    @Override
    @DeleteMapping("/del/{id}") //使用http的delete方法完成删除操作
    public ResponseResult delete(@PathVariable("id") String id) {

        return noticeService.delete(id);
    }
}
