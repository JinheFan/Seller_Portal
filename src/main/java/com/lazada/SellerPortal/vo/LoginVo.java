package com.lazada.SellerPortal.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginVo {

    @NotEmpty(message = "email must not be null")
    private String email;

    @NotEmpty(message = "password must not be null")
    private String password;

}
