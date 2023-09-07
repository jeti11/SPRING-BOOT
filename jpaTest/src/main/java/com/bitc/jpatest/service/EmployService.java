package com.bitc.jpatest.service;

import com.bitc.jpatest.data.dto.EmployeesDTO;
import com.bitc.jpatest.data.entity.EmployEntity;

import java.util.List;

public interface EmployService {
  EmployEntity getEmployeeMemberInfo(int empNo);

  List<EmployEntity> getEmployeeMemberInfoList(String firstName);

  EmployeesDTO getMemberInfoEmpNO(int empNo);
  List<EmployeesDTO> getMemberInfoListEmpName(String empName);
}
