package com.bitc.sequrityquiz.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AddMemberRequest {

  private String userId;
  private String pass;
  private String name;
  private LocalDate regidate = LocalDate.now();

}
