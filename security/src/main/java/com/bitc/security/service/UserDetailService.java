package com.bitc.security.service;

import com.bitc.security.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// UserDetailsService : 스프링 시큐리티에서 제공하는 인터페이스로 사용자 정보를 가져옴
@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  // UserDetailsService 인터페이스가 제공하는 사용자 정보를 가져오는 추상메소드를 구현
  // User 객체의 데이터를 부모 인터페이스인 UserDetails 타입으로 저장하여 반환하는 자바 문법 적용
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    // 정상적으로 데이터를 가져올 경우 해당 데이터 출력
    // 그렇지 않을 경우 예외처리
    return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException(email));
  }
}
