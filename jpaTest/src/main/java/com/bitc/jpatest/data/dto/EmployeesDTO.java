package com.bitc.jpatest.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {
  private int empNo;
  private String empName;
  private char empGender;
}
