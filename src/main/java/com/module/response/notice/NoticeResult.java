package com.module.response.notice;

import com.common.Response.ResponseResult;
import com.common.Response.ResultCode;
import com.module.entity.notice.Notice;
import lombok.Data;

/**
 * Created by mrt on 2018/3/31.
 * 将部门相关数据封装在这里，然后返回给前端
 */
@Data
public class NoticeResult extends ResponseResult {
    Notice notice;
    public NoticeResult(ResultCode resultCode, Notice notice) {
        super(resultCode);
        this.notice = notice;
    }
}
