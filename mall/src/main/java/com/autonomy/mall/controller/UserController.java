package com.autonomy.mall.controller;

import com.autonomy.mall.constant.MallConstant;
import com.autonomy.mall.enums.ResponseEnum;
import com.autonomy.mall.form.LoginForm;
import com.autonomy.mall.form.UserRegisterForm;
import com.autonomy.mall.pojo.User;
import com.autonomy.mall.service.IUserService;
import com.autonomy.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by botong.chen on 7/6/2022 上午11:07
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm registerForm){
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> login(@Valid @RequestBody LoginForm loginForm, HttpSession session){
        ResponseVo<User> userResponseVo = userService.login(loginForm.getUsername(), loginForm.getPassword());

        session.setAttribute(MallConstant.CURRENT_USER, userResponseVo.getData());

        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        log.info("/user sessionId={}", session.getId());
        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
//        if (user == null){
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        }
        return ResponseVo.success(user);
    }

    //TODO 判断登录状态，拦截器
    @PostMapping("/user/logout")
    public ResponseVo<User> logout(HttpSession session){
        log.info("/user/logout sessionId={}", session.getId());
//        User user = (User) session.getAttribute(MallConstant.CURRENT_USER);
//        if (user == null){
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
//        }
        session.removeAttribute(MallConstant.CURRENT_USER);
        return ResponseVo.success();
    }
}
