package com.module.entity.trash.trashOutHistory;

import lombok.Data;

import java.util.Date;

/**
 * 出库记录
 * Created by huangbotao on 2020/9/21;
 */
@Data
public class TrashOutHistory {
    
    
           private String trashOutHistoryId; //医废记录id
           private Date createDate; //创建时间
           private Date outTime; //出库时间
           private String person;//出库人员
           private String outWeight;//出库重量
           private String caseNum;//转运箱编号
           private String outCompany;//转运公司
           private String carNumber;//车牌号
           private String carry; //转运人
           private String accessory;//转运人
           private String outDetail; //可出库明细
}
