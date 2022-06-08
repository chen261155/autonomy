package com.autonomy.mall.service;

import com.autonomy.mall.form.CartAddForm;
import com.autonomy.mall.form.CartUpdateForm;
import com.autonomy.mall.pojo.Cart;
import com.autonomy.mall.vo.CartVo;
import com.autonomy.mall.vo.ResponseVo;

import java.util.List;

/**
 * Created by botong.chen on 8/6/2022 上午11:53
 */
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
