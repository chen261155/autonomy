package com.autonomy.mall.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by botong.chen on 8/6/2022 上午11:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductVo {

    private Integer productId;

    /*
     * 购买的数量
     * */
    private Integer quantity;

    private String productName;

    private String productSubtitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    /*
     * 总价等于 quantity * productPrice
     * */
    private BigDecimal productTotalPrice;

    private Integer productStock;

    /*
     * 商品是否选中
     * */
    private Boolean productSelected;
}
