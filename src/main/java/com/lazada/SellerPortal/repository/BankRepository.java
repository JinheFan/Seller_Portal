package com.lazada.SellerPortal.repository;

import com.lazada.SellerPortal.entity.BankEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends PagingAndSortingRepository<BankEntity, Long> {
}
