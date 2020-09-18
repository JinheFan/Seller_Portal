package com.lazada.SellerPortal.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class BankVo {

    @NotEmpty(message = "Account Name must not be null")
    @Length(max = 50, message = "Account Name must have less than 50 characters")
    private String accountName;

    @NotEmpty(message = "Account Number must not be null")
    @Length(max = 50, message = "Account Number must have less than 50 characters")
    private String accountNumber;

    @NotEmpty(message = "Bank Name must not be null")
    @Length(max = 50, message = "Bank Name must have less than 50 characters")
    private String bankName;

    @NotEmpty(message = "SWIFT Code must not be null")
    @Pattern(regexp = "^[A-Z]{6}[A-Z0-9]{2}([A-Z0-9]{3})?$", message = "The Pattern of SWIFT Code is not valid")
    private String code;

}
