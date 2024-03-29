package com.autonomy.mall.controller;

import com.autonomy.mall.constant.MallConstant;
import com.autonomy.mall.form.CartAddForm;
import com.autonomy.mall.form.CartUpdateForm;
import com.autonomy.mall.pojo.User;
import com.autonomy.mall.service.ICartService;
import com.autonomy.mall.vo.CartVo;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by botong.chen on 8/6/2022 下午12:00
 */
@RestController
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping("/carts")
    public ResponseVo<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.list(user.getId());
    }

    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm form,
                                    HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.add(user.getId(), form);
    }

    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@PathVariable Integer productId,
                                    @Valid @RequestBody CartUpdateForm form,
                                    HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.update(user.getId(), productId, form);
    }

    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable Integer productId,
                                    HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.delete(user.getId(), productId);
    }

    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> seleteAll(HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.selectAll(user.getId());
    }

    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSeleteAll(HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.unSelectAll(user.getId());
    }

    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum(HttpSession session) {
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return cartService.sum(user.getId());
    }
}
