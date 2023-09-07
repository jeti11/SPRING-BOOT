package com.bitc.sequrityquiz.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Table(name = "jpa_board2")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(nullable = false, length = 500)
  private String content;

  @Column(nullable = false, length = 20)
  private String createId;

  @Column(nullable = false)
  @CreatedDate
  private LocalDate createDt;

  @Column(nullable = false)
  @ColumnDefault("0")
  private int hitCnt;

}
