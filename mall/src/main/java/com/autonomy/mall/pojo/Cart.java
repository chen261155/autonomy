package com.autonomy.mall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by botong.chen on 8/6/2022 上午11:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Integer productId;

    /*
     * 购买的数量
     * */
    private Integer quantity;

    /*
     * 商品是否选中
     * */
    private Boolean productSelected;
}

