package com.cxh.mybatis.mybatisdemo.enums;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



@MappedTypes(UserScore.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class UserScoreTypeHandler extends BaseTypeHandler<UserScore> {

    /*用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型；*/
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserScore parameter, JdbcType jdbcType) throws SQLException {
        // baseTypeHandler已经帮我们做了parameter的null判断
        ps.setObject(i, parameter.getValue(),jdbcType.TYPE_CODE);
    }


    // 根据字段名匹配枚举类型  一般都是走这个方法
    @Override
    public UserScore getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return UserScore.getUserScore(i);
        }

    }

    @Override
    public UserScore getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的value值，定位PersonType子类
            return UserScore.getUserScore(i);
        }
    }

    // 存储过程的返回先不写，不需要使用到
    @Override
    public UserScore getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
