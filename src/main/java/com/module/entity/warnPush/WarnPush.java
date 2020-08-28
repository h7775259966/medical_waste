package com.module.entity.warnPush;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警推送Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnPush {

	private String pushId;		//预警推送id
	private String warnTypeId;		//预警类型id
    private String warnContent;		//预警内容
    private String pushUrl;		//推送链接
    private Date pushTime;		//推送时间
    private Date createDate;		//创建时间
    private String remarks;		//备注

}