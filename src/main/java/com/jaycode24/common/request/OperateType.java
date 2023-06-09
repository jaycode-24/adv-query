package com.jaycode24.common.request;


import com.jaycode24.common.support.BelongSqlStatementHandle;
import com.jaycode24.common.support.BetweenSqlStatementHandle;
import com.jaycode24.common.support.DefaultSqlStatementHandle;
import com.jaycode24.common.support.SqlStatementHandle;
import lombok.Getter;

/**
 * @Description 查询类型
 * @Author wangcheng
 * @Date 2022/10/24 11:06
 */
@Getter
public enum OperateType {

    EQ("等于",new DefaultSqlStatementHandle("%s = %s")),
    GT("大于",new DefaultSqlStatementHandle("%s > %s")),
    LT("小于",new DefaultSqlStatementHandle("%s < %s")),
    GTE("大于等于",new DefaultSqlStatementHandle("%s >= %s")),
    LTE("小于等于",new DefaultSqlStatementHandle("%s <= %s")),
    BELONG("属于",new BelongSqlStatementHandle("%s %s")),
    BETWEEN("介于",new BetweenSqlStatementHandle("%s")),
    //a.order_id like '%#{bind.p0}%'
    CONTAIN("包含",new DefaultSqlStatementHandle("%s like CONCAT('%%',%s,'%%')")),
    ;


    private String des;

    private SqlStatementHandle sqlStatementHandle;

    OperateType(String des, SqlStatementHandle sqlStatementHandle) {
        this.des = des;
        this.sqlStatementHandle = sqlStatementHandle;
    }
}
