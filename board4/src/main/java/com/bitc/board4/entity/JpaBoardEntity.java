package com.bitc.board4.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "t_board")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JpaBoardEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int boardIdx;
  @Column(name = "title", length = 100, nullable = false)
  private String title;
  @Column(length = 500, nullable = false)
  private String content;
  @Column(nullable = false)
  private String createId;
  @Column(nullable = false)
  private LocalDateTime createDt = LocalDateTime.now();
  
  // 기본값으로 사용 시 @Column 어노테이션을 사용하지 않음
  private String updateId;
  private LocalDateTime updateDt;
  private int hitCnt;

}
