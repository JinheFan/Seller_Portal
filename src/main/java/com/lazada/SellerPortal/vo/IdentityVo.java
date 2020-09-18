package com.lazada.SellerPortal.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class IdentityVo {

    @NotEmpty
    private String documentType;

    @NotEmpty(message = "The Document number must not be null")
    @Length(max = 50, message = "The Document number must have less than 50 characters")
    private String documentNumber;
}
