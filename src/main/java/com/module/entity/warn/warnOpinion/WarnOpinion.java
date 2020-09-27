package com.module.entity.warn.warnOpinion;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 预警意见Entity
 * @author zx
 * @version 2020-08-24
 */

@Data
@ToString
public class WarnOpinion {

	private String opinionId;		//预警意见id
	private String warnTypeId;		//预警类型id
    private String hospitalId;		//所属医院id
    private int step;		//步骤阶段,1为待处理，2为待审核
    private String opinion;		//处理意见
    private String reason;		//预警原因
    private Date createDate;		//创建时间


}