package com.bitc.awstest.controller;

import lombok.ToString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AwsTestController {

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }
}
