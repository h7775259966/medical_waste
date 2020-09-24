package com.module.entity.notice;


/**
 * 公告Entity
 * @author hbt
 * @version 2020-09-06
 */

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private String noticeWriteId; //公告ID
    private String headline;   //标题
    private String issuer;     //发布人
    private String writer;     //撰稿人
    private String content;    //公告内容
    private String unit;       //发布机构
    private Date writeTime;    //发布时间
    private String status;     //发布状态
    private String picture;    //图片地址


}
