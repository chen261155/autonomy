package com.autonomy.mall.service;

import com.autonomy.mall.pojo.Order;
import com.autonomy.mall.vo.OrderVo;
import com.autonomy.mall.vo.ResponseVo;
import com.github.pagehelper.PageInfo;

/**
 * Created by botong.chen on 7/6/2022 上午10:16
 */
public interface IOrderService {

    ResponseVo<OrderVo> create(Integer uid, Integer shippingId);

    ResponseVo<PageInfo> list(Integer uid, Integer pageNum, Integer pageSize);


    ResponseVo<OrderVo> detail(Integer uid, Long orderNo);

    ResponseVo cancel(Integer uid, Long orderNo);

    void paid(Long orderNo);
}
