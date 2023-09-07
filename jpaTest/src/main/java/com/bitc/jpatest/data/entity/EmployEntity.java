package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jpa_employees")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int empNo;

  @Column(nullable = false)
  private LocalDate birthDate;

  @Column(nullable = false, length = 14)
  private String firstName;

  @Column(nullable = false, length = 16)
  private String lastName;

  @Column(nullable = false)
  private char gender;

  @Column(nullable = false)
  private LocalDate hireDate;

  @OneToMany(mappedBy = "employees")
  @ToString.Exclude
  private List<SalariesEntity> salariesList = new ArrayList<>();

  @OneToMany(mappedBy = "employees")
  @ToString.Exclude
  private List<TitlesEntity> titleList = new ArrayList<>();




}

// 문제 1) employees 데이터베이스의 employees, salaries, titles, 테이블에 대한 각각의 entity 클래스를 생성하고, 관계 설정 및 사용 repository를 생성하세요

// 현재 데이터베이스(testdb)에서 생성
// employees가 메인 테이블, salaries, titles는 서브 테이블
// 참조키 이름은 'emp_no'로 설정