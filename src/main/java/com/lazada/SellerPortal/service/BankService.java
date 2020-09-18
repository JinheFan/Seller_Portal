package com.lazada.SellerPortal.service;

import com.lazada.SellerPortal.entity.BankEntity;
import com.lazada.SellerPortal.vo.BankVo;

public interface BankService {

    BankEntity save(BankVo vo,String userId);
}
