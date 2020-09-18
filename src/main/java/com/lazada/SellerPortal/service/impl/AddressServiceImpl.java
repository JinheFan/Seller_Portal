package com.lazada.SellerPortal.service.impl;

import com.lazada.SellerPortal.entity.AddressEntity;
import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.repository.AddressRepository;
import com.lazada.SellerPortal.repository.UserRepository;
import com.lazada.SellerPortal.service.AddressService;
import com.lazada.SellerPortal.vo.AddressVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public AddressEntity save(AddressVo vo, String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        AddressEntity addressEntity = new AddressEntity();
        BeanUtils.copyProperties(vo, addressEntity);
        addressEntity.setUserEntity(userEntity);
        addressRepository.save(addressEntity);
        return addressEntity;
    }
}
