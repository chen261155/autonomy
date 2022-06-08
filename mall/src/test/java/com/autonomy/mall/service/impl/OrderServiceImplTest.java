package com.autonomy.mall.service.impl;

import com.autonomy.mall.MallApplicationTests;
import com.autonomy.mall.pojo.Order;
import com.autonomy.mall.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by botong.chen on 7/6/2022 上午10:22
 */
@Slf4j
public class OrderServiceImplTest extends MallApplicationTests {

    @Autowired
    private IOrderService orderService;

    @Test
    public void findById() {

    }
}