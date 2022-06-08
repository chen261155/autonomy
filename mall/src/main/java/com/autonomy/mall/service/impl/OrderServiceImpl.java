package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.OrderMapper;
import com.autonomy.mall.pojo.Order;
import com.autonomy.mall.service.IOrderService;
import com.autonomy.mall.vo.OrderVo;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by botong.chen on 7/6/2022 上午10:16
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseVo<OrderVo> create(Integer uid, Integer shippingId) {
        //收货地址校验（总之都要查出来的）

        //获取购物车，校验（是否有商品、库存）

        //获取
        return null;
    }
}
