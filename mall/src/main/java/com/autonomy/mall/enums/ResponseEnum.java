package com.autonomy.mall.enums;/**
 * Created by botong.chen on 7/6/2022 上午11:23
 */

import lombok.Getter;

/***
 *  Created by botong.chen 2022-06-07 11:23
 **/
@Getter
public enum ResponseEnum {

    ERROR(-1, "服务端错误"),

    SUCCESS(0, "成功"),

    PASSWORD_ERROR(1, "密码错误"),

    USERNAME_EXIT(2, "用户已存在"),

    PARAM_ERROR(3, "参数错误"),

    EMAIL_EXIT(4, "邮件已存在"),

    NEED_LOGIN(10, "用户未登录，请先登录"),

    USERNAME_OR_PASSWORD_ERROR(11, "用户或密码错误"),

    PRODUCT_OFF_SALE_OR_DELETE(12, "该商品已下架或删除"),

    PRODUCT_NO_EXIT(13, "商品不存在"),

    PRODUCT_STOCK_ERROR(14, "商品库存不正确"),

    CART_PRODUCT_NOT_EXIST(15, "购物车无此商品"),

    CREATE_SHIPPING_FAIL(16, "新建地址失败"),

    CREATE_SHIPPING_SUCCESS(21, "新建地址成功"),

    DELETE_SHIPPING_FAIL(17, "删除地址失败"),

    DELETE_SHIPPING_SUCCESS(18, "删除地址成功"),

    UPDATE_SHIPPING_FAIL(19, "更新地址失败"),

    UPDATE_SHIPPING_SUCCESS(20, "更新地址成功"),

    SHIPPING_NOT_EXIST(21, "收货地址不存在"),

    CART_SELECTED_IS_EMPTY(22, "请选择商品后下单"),

    PRODCT_NOT_EXIST(23, "商品不存在"),

    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }
}
