package com.module.entity.trash.trashOut;

import lombok.Data;

import java.util.Date;

/**
 * 医废出库Entity
 * Created by huangbotao on 2020/9/1;
 */
@Data
public class TrashOut {
    
            private String trashOutId;  //医废出库id
            private Date createDate;  //创建时间
            private Date collectTime; //收集时间
            private String status;  //出库状态
            private String collectWeight; //收集重量
            private String putWeight; //已入库重量
            private String outWeight; //出库重量
            private String outDetail; //可出库明细
}
