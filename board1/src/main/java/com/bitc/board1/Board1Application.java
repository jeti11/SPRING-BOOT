package com.bitc.board1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

// 스프링부트 : 스프링을 쉽게 사용하기 위해서 자동설정기능이 있음
// -> apache commons-fileupload 라이브러리를 사용하면 설정 충돌이 발생함
// -> (exclude = {MultipartAutoConfiguration.class})을 추가하여 Multipart 데이터에 대해서 자동 설정을 제외함
// -> WebMvcConfigurer 를 상속받아서 사용자 설정을추가함
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class Board1Application {

  public static void main(String[] args) {
    SpringApplication.run(Board1Application.class, args);
  }

}
