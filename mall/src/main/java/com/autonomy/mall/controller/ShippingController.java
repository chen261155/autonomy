package com.autonomy.mall.controller;

import com.autonomy.mall.constant.MallConstant;
import com.autonomy.mall.form.ShippingForm;
import com.autonomy.mall.pojo.User;
import com.autonomy.mall.service.IShippingService;
import com.autonomy.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by botong.chen on 8/6/2022 下午5:07
 */
@RestController
public class ShippingController {
    @Autowired
    private IShippingService shippingService;

    @PostMapping("/shippings")
    public ResponseVo add(@Valid @RequestBody ShippingForm form,
                          HttpSession session){
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    public ResponseVo delete(@PathVariable Integer shippingId,
                          HttpSession session){
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    public ResponseVo update(@PathVariable Integer shippingId,
                             @Valid @RequestBody ShippingForm form,
                             HttpSession session){
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, form);
    }

    @GetMapping("/shippings")
    public ResponseVo list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                             HttpSession session){
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }
}
