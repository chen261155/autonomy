package com.autonomy.mall.enums;

import lombok.Getter;

/**
 * Created by botong.chen on 10/6/2022 下午5:49
 */
@Getter
public enum  OrderStatusEnum {

    CANCELED(0, "已取消"),

    NO_PAY(10, "w未付款"),

    PAID(20, "已付款"),

    SHIPPED(40, "已发货"),

    TRADE_SUCCESS(50, "交易成功"),

    TRADE_CLOSE(60, "交易关闭"),

    ;

    Integer code;

    String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
