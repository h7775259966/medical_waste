package com.module.entity.route;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 线路配置表
 * Created by huangbotao on 2020/9/29;
 */

@Data
@ToString
public class Route {

    private String lineConfigId; //线路配置id
    private String collectId; //收集人id
    private Date createDate; //创建时间
    private String routeName; //线路名称
    private String equipmentNum; //小车编号
    private String config; //配置人


}
