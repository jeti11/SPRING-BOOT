package com.bitc.security.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
  // 로그인 id로 사용할 email
  private String email;
  private String password;
}
