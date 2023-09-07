package com.bitc.xml_json_parser.projectDTO;

import lombok.Data;

@Data
public class ReservationTpDTO {
  private int reservationIdx;
  private int customerIdx;
  private int ceoIdx;
  private int reservationStat;
  private int reservationPeople;
  private String reservationContents;
  private String reservationDate;
  private int reservationTime;
}
