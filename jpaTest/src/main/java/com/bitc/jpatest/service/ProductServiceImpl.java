package com.bitc.jpatest.service;

import com.bitc.jpatest.data.entity.ProductEntity;
import com.bitc.jpatest.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public void finds() throws Exception {
    System.out.println("\n ----- findBy() 쿼리 메소드 실행 ----- \n");

    Optional<ProductEntity> prod1 = productRepository.findByNumber((long) 1);
    Optional<ProductEntity> prod2 = productRepository.findProductEntityByNumber((long) 1);
    List<ProductEntity> prod3 = productRepository.findAllByName("볼펜");
    List<ProductEntity> prod4 = productRepository.queryByName("사인펜");

    System.out.println("\n ----- finds() 쿼리 메소드 실행 완료 ----- \n");

  }

  @Override
  public void exists() throws Exception {
    System.out.println("\n ----- exists() 쿼리 메소드 실행 ----- \n");
    boolean isProduct = productRepository.existsByNumber((long) 200);
  }

  @Override
  public void count() throws Exception {
    System.out.println("\n ----- count() 쿼리 메소드 실행 ----- \n");
    int productCount = productRepository.countByName("볼펜");
  }

  @Override
  public void delete() throws Exception {

  }

  @Override
  public void limit() throws Exception {

  }

  @Override
  public void equals() throws Exception {

  }

  @Override
  public void isNot() throws Exception {

  }

  @Override
  public void isNull() throws Exception {

  }

  @Override
  public void isNotNull() throws Exception {

  }

  @Override
  public void and() throws Exception {
    System.out.println("\n ----- and() 쿼리 메소드 실행 ----- \n");
    ProductEntity prod1 = productRepository.findByNumberAndName((long) 4, "볼펜");
    ProductEntity prod2 = productRepository.findByNumberAndName((long) 4, "사인펜");

  }

  @Override
  public void or() throws Exception {

  }

  @Override
  public void between() throws Exception {

  }

  @Override
  public void like() throws Exception {

  }

  @Override
  public void orderBy() throws Exception {

  }

  @Override
  public void querySelectAll() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectAll() 실행 ----- \n");

    List<ProductEntity> prod = productRepository.querySelectAll();
  }

  @Override
  public void querySelectName() throws Exception {
    System.out.println("\n ----- @Query 사용, querySelectName() 실행 ----- \n");

    ProductEntity prod1 = productRepository.querySelectName();
    ProductEntity prod2 = productRepository.querySelectName("사인펜");
    ProductEntity prod3 = productRepository.querySelectNamePrice("샤프펜", 500);
  }
}
