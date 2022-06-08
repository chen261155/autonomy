package com.autonomy.mall.service;

import com.autonomy.mall.pojo.Order;
import com.autonomy.mall.vo.OrderVo;
import com.autonomy.mall.vo.ResponseVo;

/**
 * Created by botong.chen on 7/6/2022 上午10:16
 */
public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);
}
