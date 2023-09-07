package com.bitc.sequrityquiz.service;

import com.bitc.sequrityquiz.data.repository.MemberRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    return memberRepository.findByUserId(userId).orElseThrow(() -> new
      IllegalArgumentException(userId));
  }
}
