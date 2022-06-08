package com.autonomy.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by botong.chen on 7/6/2022 上午11:56
 */
@Data
public class LoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
