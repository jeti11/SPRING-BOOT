package com.bitc.jpatest.controller;

import com.bitc.jpatest.service.EmployService;
import com.bitc.jpatest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class JpaTestController {

  private final ProductService productService;
  private final EmployService employService;

  @RequestMapping("/")
  public String index() throws Exception {
    productService.finds();
    productService.count();
    productService.and();

    return "success";
  }

  @RequestMapping("/query")
  public String query() throws Exception {

    productService.querySelectAll();
    productService.querySelectName();

    return "success";
  }

  @RequestMapping("/emp")
  public String employ() throws Exception {
//    employService.find();
    employService.getEmployeeMemberInfo(10009);
    employService.getEmployeeMemberInfoList("mario");

    return "success";
  }

}
