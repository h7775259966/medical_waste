package com.module.entity.custom;

import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/22;
 * 自定义查询数据
 */

@Data
@ToString
public class Custom {

    private String violationWeight; //医废重量
    private String Packets; //医废包数
    private String trashType; //医废类型


}
