package com.autonomy.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by botong.chen on 13/6/2022 下午2:09
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;
}
