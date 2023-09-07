package com.bitc.xml_json_parser.projectDTO;

import lombok.Data;

@Data
public class CustomerTpDTO {
  private int customerIdx;
  private String customerId;
  private String customerPw;
  private String customerName;
  private String customerNick;
  private String customerGender;
  private int customerAge;
  private String customerFollows;
  private int customerGrade;
}
