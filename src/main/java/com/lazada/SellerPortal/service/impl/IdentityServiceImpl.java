package com.lazada.SellerPortal.service.impl;

import com.lazada.SellerPortal.entity.IdentityEntity;
import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.repository.IdentityRepository;
import com.lazada.SellerPortal.repository.UserRepository;
import com.lazada.SellerPortal.service.IdentityService;
import com.lazada.SellerPortal.vo.IdentityVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityServiceImpl implements IdentityService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    IdentityRepository identityRepository;

    @Override
    public IdentityEntity save(IdentityVo vo, String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        IdentityEntity identityEntity = new IdentityEntity();
        BeanUtils.copyProperties(vo, identityEntity);
        identityEntity.setUserEntity(userEntity);
        IdentityEntity save = identityRepository.save(identityEntity);
        return save;
    }
}
