package com.lazada.SellerPortal.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationVo {

    @NotNull
    private String accoutType;

    @NotNull
    private String shopBased;

    @NotNull(message = "mobileNumber must not null")
    @Pattern(regexp = "^(?:[0-9] ?){6,14}[0-9]$", message = "pattern of phone number is not valid")
    private String mobileNumber;

    @NotNull(message = "email must not null")
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "pattern of email is not valid")
    private String email;

    @NotNull(message = "password must not null")
    @Length(min = 10, max = 30, message = "length of password must between 10 and 30")
    private String password;

}
