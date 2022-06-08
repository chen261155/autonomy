package com.autonomy.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by botong.chen on 7/6/2022 上午11:50
 */
@Data
public class UserRegisterForm {

    //@NotBlank 用于 String 判断空格
    //@NotEmpty 用于集合
    //@NotNull
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
