package com.cxh.mybatis.mybatisdemo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.omg.CORBA.UNKNOWN;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author CXH
 * @description
 * @create 2022-07-25 16:58
 */
public enum UserScore{
    A(0,"prefect"),
    B(1,"excellent"),
    C(2,"good"),
    UNKNOWN(3,"unknown");

    private  int value;
    private  String description;
    UserScore(int value,String description){
        this.value = value;
        // desc  数据库中的字段，char（1）
        this.description = description;
    }

    @JsonValue // 用于返回前端时指定返回对应字段的值  而不是返回枚举名
    public int getValue() {
        return value;
    }

    @JsonCreator
    public String getDescription() {
        return description;
    }

    // 通过值获取对应的枚举
    public static UserScore getUserScore(int value) {
        UserScore[] enumConstants = UserScore.class.getEnumConstants();
        for (UserScore enumConstant : enumConstants) {
            if (value==enumConstant.getValue()) {
                return enumConstant;
            }
        }
        return UNKNOWN;
    }

}
