package com.module.controller.notice;


import com.common.Response.QueryResponseResult;
import com.common.Response.ResponseResult;
import com.module.entity.notice.Notice;
import com.module.request.notice.NoticeRequest;;
import com.module.response.notice.NoticeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="notice接口",description = "公告")
public interface NoticeControllerApi {

    @ApiOperation("分页查询公告列表")
    @ApiImplicitParams({
            //required=true是否必填，paramType="path"是http请求路径，dataType="int"数据类型
            @ApiImplicitParam(name="page",value = "页 码",required=true,paramType="path",dataType="int"),
            @ApiImplicitParam(name="size",value = "每页记录 数",required=true,paramType="path",dataType="int") })
    public QueryResponseResult findList(int page, int size, NoticeRequest noticeRequest) ;

    @ApiOperation("添加公告")
    public NoticeResult add(Notice notice);

    @ApiOperation("通过id查询公告")
    public NoticeResult findById(String id);

    @ApiOperation("通过id修改公告")
    public NoticeResult edit(String id, Notice notice);

    @ApiOperation("通过id删除公告")
    public ResponseResult delete(String id);
}
