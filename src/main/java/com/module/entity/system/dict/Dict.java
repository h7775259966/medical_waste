package com.module.entity.system.dict;

import lombok.Data;
import lombok.ToString;
import java.util.Date;

/**
 * 系统字典Entity
 * @author zx
 * @version 2020-09-17
 */

@Data
@ToString
public class Dict {

	private String id;		   //字典id
    private String dictApi;        //字典api
	private String dictLabel;		//字典内容
    private String dictValue;		//字典数据
    private Date createDate;		//创建时间
    private String remarks;		//备注

}