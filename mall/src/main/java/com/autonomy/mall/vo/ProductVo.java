package com.autonomy.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by botong.chen on 7/6/2022 下午5:08
 */
@Data
public class ProductVo {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private Integer status;

    private BigDecimal price;

}
