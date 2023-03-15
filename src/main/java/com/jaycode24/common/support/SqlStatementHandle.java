package com.jaycode24.common.support;



import com.jaycode24.common.request.Filter;

import java.util.Map;

/**
 * @Description sql语句处理器：产生单个查询的sql
 * @Author wangcheng
 * @Date 2022/10/24 11:15
 */
public interface SqlStatementHandle {

    String createCondition(Filter filter, Map<String, Object> bind, String namePrefix);
}
