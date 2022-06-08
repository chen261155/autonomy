package com.autonomy.mall.service.impl;

import com.autonomy.mall.MallApplicationTests;
import com.autonomy.mall.form.CartAddForm;
import com.autonomy.mall.service.ICartService;
import com.autonomy.mall.vo.CartVo;
import com.autonomy.mall.vo.ResponseVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by botong.chen on 8/6/2022 下午2:14
 */
@Slf4j
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(26);
        form.setSelected(true);
        cartService.add(1, form);
    }

    @Test
    public void list(){
        ResponseVo<CartVo> list = cartService.list(1);
        log.info("list={}", gson.toJson(list));
    }
}