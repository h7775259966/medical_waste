package com.module.entity.trash.trashOutMessage;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 出库转运信息Entity
 * @author zx
 * @version 2020-10-12
 */

@Data
@ToString
public class TrashOutMessage {

	private String id;		   //转运id
    private int type;        //信息类型
	private String content;		//信息内容
    private Date createDate;		//创建时间
    private String remarks;		//备注

}