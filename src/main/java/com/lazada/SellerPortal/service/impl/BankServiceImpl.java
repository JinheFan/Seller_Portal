package com.lazada.SellerPortal.service.impl;

import com.lazada.SellerPortal.entity.BankEntity;
import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.repository.BankRepository;
import com.lazada.SellerPortal.repository.UserRepository;
import com.lazada.SellerPortal.service.BankService;
import com.lazada.SellerPortal.vo.BankVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BankRepository bankRepository;

    @Override
    public BankEntity save(BankVo vo, String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        BankEntity bankEntity = new BankEntity();
        BeanUtils.copyProperties(vo, bankEntity);
        bankEntity.setUserEntity(userEntity);
        BankEntity save = bankRepository.save(bankEntity);
        return save;
    }
}
