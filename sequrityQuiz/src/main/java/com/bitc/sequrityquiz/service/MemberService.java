package com.bitc.sequrityquiz.service;

import com.bitc.sequrityquiz.data.dto.AddMemberRequest;

public interface MemberService {

  Integer save(AddMemberRequest member) throws Exception;
}
