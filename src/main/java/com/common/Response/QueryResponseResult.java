package com.common.Response;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Zhouxin on 2020/8/24;
 */
@Data
@ToString
public class QueryResponseResult extends ResponseResult {

   QueryResult queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult queryResult){
        super(resultCode);
       this.queryResult = queryResult;
    }

}
