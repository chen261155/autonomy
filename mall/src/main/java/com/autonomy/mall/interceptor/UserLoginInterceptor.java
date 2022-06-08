package com.autonomy.mall.interceptor;

import com.autonomy.mall.constant.MallConstant;
import com.autonomy.mall.exception.UserLoginException;
import com.autonomy.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by botong.chen on 7/6/2022 下午3:07
 * 拦截器
 * 拦截一些API 需要登录才能访问
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle::::");
        User user = (User) request.getSession().getAttribute(MallConstant.CURRENT_USER);
        if (user == null){
            log.info("user==null");
            throw new UserLoginException();
        }

//        response.getWriter().print("error");
//			return false;
//			return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        return true;
    }
}
