package com.module.entity.route;

import lombok.Data;
import lombok.ToString;

/**
 * Created by huangbotao on 2020/9/29;
 */
@Data
@ToString
public class RouteAndOffice {

    private String id; //主键
    private String officeName; //科室名称
    private String officeId; //科室编号
    private String Xaxis; //X轴刻度
    private String Yaxis; //Y轴刻度
    private String routeId; //线路ID


}
