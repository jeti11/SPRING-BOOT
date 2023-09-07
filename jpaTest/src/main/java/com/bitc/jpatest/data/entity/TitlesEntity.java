package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_titles")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TitlesEntity extends Quiz1BaseEntity {
  @Id
  @ManyToOne
  @JoinColumn(name = "emp_no")
  @ToString.Exclude
  private EmployEntity employees;

  @Id
  private String title;

  @Id
  @CreatedDate
  private LocalDate fromDate;

}
