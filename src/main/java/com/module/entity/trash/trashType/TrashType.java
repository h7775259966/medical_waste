package com.module.entity.trash.trashType;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 医废类型Entity
 * @author zx
 * @version 2020-08-26
 */

@Data
@ToString
public class TrashType {

	private String trashId;		 //医废类型id
    private String trashType;    //类型名称
    private Date createDate;	 //创建时间
    private String remarks;		 //备注

}