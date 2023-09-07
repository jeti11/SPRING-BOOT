package com.bitc.sequrityquiz.data.repository;

import com.bitc.sequrityquiz.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

  Optional<Member> findByUserId(String userId);
}
