package com.autonomy.mall.enums;

import lombok.Getter;

/**
 * Created by botong.chen on 7/6/2022 上午10:58
 */
@Getter
public enum  RoleEnum {

    ADMIN(0),

    CUSTOMER(1),
    ;

    Integer code;

    RoleEnum(Integer code){this.code = code;}
}
