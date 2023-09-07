package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetailEntity, Long> {
  
}

