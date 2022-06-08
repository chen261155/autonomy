package com.autonomy.mall.service;

import com.autonomy.mall.pojo.User;
import com.autonomy.mall.vo.ResponseVo;

/**
 * Created by botong.chen on 7/6/2022 上午10:40
 */
public interface IUserService {

    ResponseVo<User> register(User user);


    ResponseVo<User> login(String username, String password);
}
