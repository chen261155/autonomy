package com.autonomy.mall.enums;

import lombok.Getter;

/**
 * Created by botong.chen on 7/6/2022 下午6:14
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),

    ;

    Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
