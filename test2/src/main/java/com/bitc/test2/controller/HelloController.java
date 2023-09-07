package com.bitc.test2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
  // PORT 번호 변경 : application.properties 파일에서 수정하면 됨

  @RequestMapping("/") // url
  public String index() {
    return "index"; // html 파일명, templates이 기본폴더로 설정되어 있기 때문에 앞에 '/' 안붙여도됨
  }

  @RequestMapping("/hello")
  public String hello() {
    return "hello";
  }
}
