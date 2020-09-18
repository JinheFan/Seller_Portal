package com.lazada.SellerPortal.repository;

import com.lazada.SellerPortal.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    UserEntity findByMobileNumber(String mobileNumber);

    UserEntity findByUserId(String userId);
}
