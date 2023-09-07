package com.bitc.sequrityquiz.service;

import com.bitc.sequrityquiz.data.dto.AddMemberRequest;
import com.bitc.sequrityquiz.data.entity.Member;
import com.bitc.sequrityquiz.data.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public Integer save(AddMemberRequest member) throws Exception {
    return memberRepository.save(
        Member.builder()
          .userId(member.getUserId())
          .pass(bCryptPasswordEncoder.encode(member.getPass()))
          .name(member.getName())
          .regidate((member.getRegidate()))
          .build()).getMemberIdx();
  }
}
