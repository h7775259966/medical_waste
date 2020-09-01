package com.module.entity.warn.warnType;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警类型Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnType {

	private String warnTypeId;		//预警类型id
	private String warnType;		//预警类型
    private String warnContent;		//预警内容
    private Date createDate;		//创建时间
    private String remarks;		//备注

}