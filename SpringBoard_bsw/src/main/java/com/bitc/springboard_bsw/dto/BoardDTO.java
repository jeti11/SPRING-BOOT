package com.bitc.springboard_bsw.dto;

import lombok.Data;

@Data
public class BoardDTO {
  private int idx;
  private String title;
  private String content;
  private String createId;
  private String createDt;
  private String updateId;
  private String updateDt;
  private int hitCnt;
}
