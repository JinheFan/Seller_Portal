package com.lazada.SellerPortal.repository;

import com.lazada.SellerPortal.entity.IdentityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRepository extends PagingAndSortingRepository<IdentityEntity, Long> {
}
