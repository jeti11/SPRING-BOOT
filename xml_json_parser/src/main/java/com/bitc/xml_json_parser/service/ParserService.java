package com.bitc.xml_json_parser.service;

import com.bitc.xml_json_parser.dto.DailyBoxOfficeDTO;
import com.bitc.xml_json_parser.dto.PharmacyFullDataItemDTO;

import java.util.List;

public interface ParserService {
  List<PharmacyFullDataItemDTO> getItemListFile(String filePath) throws Exception;

  List<PharmacyFullDataItemDTO> getItemListUrl(String url) throws Exception;


  List<DailyBoxOfficeDTO> getDailyBoxOfficeList(String url) throws Exception;
}
