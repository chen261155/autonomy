package com.autonomy.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by botong.chen on 8/6/2022 上午11:47
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVo;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;
}
