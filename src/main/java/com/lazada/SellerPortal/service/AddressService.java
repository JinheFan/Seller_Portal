package com.lazada.SellerPortal.service;

import com.lazada.SellerPortal.entity.AddressEntity;
import com.lazada.SellerPortal.vo.AddressVo;

public interface AddressService {
    AddressEntity save(AddressVo vo, String userId);
}
