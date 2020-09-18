package com.lazada.SellerPortal.service.impl;

import com.lazada.SellerPortal.common.Utils;
import com.lazada.SellerPortal.entity.UserEntity;
import com.lazada.SellerPortal.exception.ErrorMessage;
import com.lazada.SellerPortal.exception.UserServiceException;
import com.lazada.SellerPortal.repository.UserRepository;
import com.lazada.SellerPortal.service.UserService;
import com.lazada.SellerPortal.vo.LoginVo;
import com.lazada.SellerPortal.vo.RegistrationVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserEntity createUser(RegistrationVo vo) {
        String phone = vo.getMobileNumber();
        String email = vo.getEmail();
        UserEntity byMobileNumber = userRepository.findByMobileNumber(phone);
        UserEntity byEmail = userRepository.findByEmail(email);
        if (byMobileNumber != null || byEmail != null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(vo, userEntity);
        String userId = utils.generateUserId(10);
        userEntity.setUserId(userId);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(passwordEncoder.encode(vo.getPassword()));

        UserEntity save = userRepository.save(userEntity);
        return save;
    }

    @Override
    public UserEntity authenticate(LoginVo vo) {
        String email = vo.getEmail();
        UserEntity entityDb = userRepository.findByEmail(email);
        if (entityDb == null) {
            return null;
        } else {
            String password = vo.getPassword();
            String passwordDb = entityDb.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean matches = passwordEncoder.matches(password, passwordDb);
            if (matches) {
                return entityDb;
            } else {
                return null;
            }
        }
    }
}
