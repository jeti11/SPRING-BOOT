package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_salaries")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SalariesEntity extends Quiz1BaseEntity{
  @Id
  @ManyToOne
  @JoinColumn(name = "emp_no")
  @ToString.Exclude
  private EmployEntity employees;

  @Column(nullable = false)
  private int salary;

//  @Column(nullable = false)
//  private LocalDate fromDate;
//
//  @Column(nullable = false)
//  private LocalDate toDate;

  @Id
  @CreatedDate
  private LocalDateTime fromDate;





}
