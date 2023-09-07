package com.bitc.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

  @RequestMapping("/")
  public String index() {
    return "index";
  }

  @RequestMapping("/test1")
  public String test1() {
    return "test1";
  }


  // 아래 세가지 방법 중 아무거나 사용해도 됨
  @RequestMapping(value = "/test2", method = RequestMethod.POST)
  public String test2() {
    return "test2";
  }

  @PostMapping("/test3")
  public String test3() {
    return "test3";
  }

//  @GetMapping("/test3")
//  public String test3() {
//    return "test3";
//  }
}
