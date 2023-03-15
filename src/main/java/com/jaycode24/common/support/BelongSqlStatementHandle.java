package com.jaycode24.common.support;


import com.jaycode24.common.request.Filter;

import java.util.List;
import java.util.Map;

/**
 * @Description IN 语句处理器
 * @Author wangcheng
 * @Date 2022/10/24 14:13
 */
public class BelongSqlStatementHandle extends AbstractSqlStatementHandle{

    public BelongSqlStatementHandle(String pattern) {
        super(pattern);
    }

    @Override
    String handle(Filter filter, Map<String, Object> bind, String namePrefix) {
        if (filter.getValue() instanceof List){
            List<Object> valueList = (List<Object>) filter.getValue();
            String valueStatement = "in (";

            for (int i = 0; i < valueList.size(); i++) {
                //p00,p01...
                String newNamePrefix = namePrefix + i;
                valueStatement = valueStatement + "#{bind." + newNamePrefix + "},";
                bind.put(newNamePrefix,valueList.get(i));
            }
            return valueStatement.substring(0,valueStatement.length()-1) + ")";
        }
        return "";

    }
}
