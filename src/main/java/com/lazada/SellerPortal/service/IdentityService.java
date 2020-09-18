package com.lazada.SellerPortal.service;

import com.lazada.SellerPortal.entity.IdentityEntity;
import com.lazada.SellerPortal.vo.IdentityVo;

public interface IdentityService {
    IdentityEntity save(IdentityVo vo, String userId);
}
