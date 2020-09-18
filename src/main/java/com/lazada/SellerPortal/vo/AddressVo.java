package com.lazada.SellerPortal.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressVo {

    @NotEmpty(message = "Line1 must not be null")
    @Length(max = 50)
    private String line1;

    @Length(max = 50)
    private String line2;

    @NotEmpty(message = "City must not be null")
    @Length(max = 30)
    private String city;

    @NotEmpty(message = "PostCode must not be null")
    @Length(max = 30)
    private String postCode;


    private String country;

}
