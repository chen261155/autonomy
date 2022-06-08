package com.autonomy.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by botong.chen on 8/6/2022 上午11:48
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected;
}
