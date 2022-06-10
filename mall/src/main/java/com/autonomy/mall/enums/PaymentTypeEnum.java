package com.autonomy.mall.enums;

import lombok.Getter;

/**
 * Created by botong.chen on 10/6/2022 下午5:47
 */
@Getter
public enum  PaymentTypeEnum {

    PAY_ONLINE(1),
    ;

    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
