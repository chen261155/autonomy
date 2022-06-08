package com.autonomy.mall.service.impl;

import com.autonomy.mall.dao.UserMapper;
import com.autonomy.mall.enums.ResponseEnum;
import com.autonomy.mall.enums.RoleEnum;
import com.autonomy.mall.pojo.User;
import com.autonomy.mall.service.IUserService;
import com.autonomy.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

import static com.autonomy.mall.enums.ResponseEnum.*;

/**
 * Created by botong.chen on 7/6/2022 上午10:42
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseVo<User> register(User user) {
        //		error();

        //username不能重复
        int countByUsername = userMapper.countByUsername(user.getUsername());
        if (countByUsername > 0){
            return ResponseVo.error(USERNAME_EXIT);
        }

        //email不能重复
        int countByEmail = userMapper.countByEmail(user.getEmail());
        if (countByEmail > 0){
            return ResponseVo.error(EMAIL_EXIT);
        }

        //MD5摘要算法(Spring自带)
        user.setRole(RoleEnum.CUSTOMER.getCode());
        user.setPassword(DigestUtils.md5DigestAsHex(
                user.getPassword().getBytes(StandardCharsets.UTF_8 )
        ));

        //写入数据库
        int resultCount = userMapper.insertSelective(user);
        if (resultCount == 0){
            return ResponseVo.error(ERROR);
        }
        return ResponseVo.success();
    }

    @Override
    public ResponseVo<User> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null){
            //用户不存在（返回：用户名或密码错误 ）
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }
        if (!user.getPassword().equalsIgnoreCase(
                DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)))){
            //密码错误(返回：用户名或密码错误 )
            return ResponseVo.error(USERNAME_OR_PASSWORD_ERROR);
        }
        user.setPassword("");
        return ResponseVo.success(user);
    }

    private void error() {
        throw new RuntimeException("意外错误");
    }

}
