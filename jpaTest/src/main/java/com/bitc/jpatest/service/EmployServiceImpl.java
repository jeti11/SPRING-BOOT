package com.bitc.jpatest.service;

import com.bitc.jpatest.data.dto.EmployeesDTO;
import com.bitc.jpatest.data.entity.EmployEntity;
import com.bitc.jpatest.data.repository.EmployRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployServiceImpl implements EmployService {

  private final EmployRepository employRepository;


//  @Override
//  public void find() throws Exception {
//    EmployEntity getEmployeeMember = employRepository.findByEmpNo(10009);
//    List<EmployEntity> emp = employRepository.findAllByFirstName("Georgi");
//
//    List<EmployEntity> empQueryFirstName1 = employRepository.querySelectFirstName("Georgi");
//    List<EmployEntity> empQueryFirstName2 = employRepository.querySelectFirstName2("Georgi");
//
//
//  }

  @Override
  public EmployEntity getEmployeeMemberInfo(int empNo) {
    Optional<EmployEntity> empInfo = employRepository.findByEmpNo(empNo);

    if (empInfo.isPresent()) {
      EmployEntity emp = empInfo.get();
      return emp;
    }
    else {
      return null;
    }
  }

  @Override
  public List<EmployEntity> getEmployeeMemberInfoList(String firstName) {
    List<EmployEntity> empList = employRepository.findAllByFirstName(firstName);
    return empList;
  }

  
  // 사원 1명의 정보를 사원 번호로 가져옴
  @Override
  public EmployeesDTO getMemberInfoEmpNO(int empNo) {
    Optional<EmployEntity> empInfo = employRepository.findByEmpNo(empNo);

    EmployeesDTO member = new EmployeesDTO();
    member.setEmpNo(empInfo.get().getEmpNo());
    member.setEmpName(empInfo.get().getFirstName() + empInfo.get().getLastName());
    member.setEmpGender(empInfo.get().getGender());

    return member;
  }


  // 사원 정보를 사원 이름을 기반으로 해서 모두 가져옴
  @Override
  public List<EmployeesDTO> getMemberInfoListEmpName(String empName) {
    List<EmployeesDTO> memberList = new ArrayList<>();

    List<EmployEntity> empList = employRepository.findAllByFirstName(empName);

    for (EmployEntity item : empList) {
      EmployeesDTO member = new EmployeesDTO();
      member.setEmpNo(item.getEmpNo());
      member.setEmpName(item.getFirstName() + item.getLastName());
      member.setEmpGender(item.getGender());

      memberList.add(member);
    }

    return memberList;
  }
}



























