package com.common.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Data
@ToString
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
