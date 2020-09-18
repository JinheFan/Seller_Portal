package com.lazada.SellerPortal.service;

import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.vo.LoginVo;
import com.lazada.SellerPortal.vo.RegistrationVo;

public interface UserService {
    UserEntity createUser(RegistrationVo vo);

    UserEntity authenticate(LoginVo vo);
}
