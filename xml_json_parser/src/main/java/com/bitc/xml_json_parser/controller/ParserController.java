package com.bitc.xml_json_parser.controller;

import com.bitc.xml_json_parser.dto.DailyBoxOfficeDTO;
import com.bitc.xml_json_parser.dto.PharmacyFullDataItemDTO;
import com.bitc.xml_json_parser.service.ParserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/parse")
public class ParserController {
  @Autowired
  private ParserService parserService;

  // application.properties 속성에 저장한 데이터를 변수로 생성
  @Value("${full505.kobis.json.DailyBoxOfficeUrl}")
  private String serviceUrl;

  @Value("${full505.kobis.json.key}")
  private String serviceKey;


  @RequestMapping({"/", ""})
  public String index() throws Exception {
    return "index";
  }

  @GetMapping("/pharmacy/fullDataFile")
  public ModelAndView getFullDataFile() throws Exception {
    ModelAndView mv = new ModelAndView("pharmacy/fullDataFile");
    List<PharmacyFullDataItemDTO> itemList = parserService.getItemListFile("c:\\smart505\\pharmacy.xml");

    mv.addObject("itemList", itemList);

    return mv;
  }

  @GetMapping("/pharmacy/fullDataUrl")
  public String getFullDataUrl() throws Exception {
    return "pharmacy/fullDataUrl";
  }

  @ResponseBody
  @PostMapping("/pharmacy/fullDataUrl")
  public Object getFullDataUrl(@RequestParam("pageNo") String pageNo, @RequestParam("numOfRows") String numOfRows) throws Exception {

    String serviceUrl = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown";
    String servicekey = "?serviceKey=rGKUrEZhOepRsEGqY6SaRqFKjidQ9aLqDAKXa%2FTgk4KrBbTLEVmRIQ%2Fe4kGV2hv3tI3LhSLgZPMQC8EMGE9Msg%3D%3D";
    String opt1 = "&pageNo=" + pageNo;
    String opt2 = "&numOfRows=" + numOfRows;

    List<PharmacyFullDataItemDTO> itemList = parserService.getItemListUrl(serviceUrl + servicekey + opt1 + opt2);

//    http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=rGKUrEZhOepRsEGqY6SaRqFKjidQ9aLqDAKXa%2FTgk4KrBbTLEVmRIQ%2Fe4kGV2hv3tI3LhSLgZPMQC8EMGE9Msg%3D%3D&pageNo=1&numOfRows=10

    return itemList;
  }

  // 영화진흥위원회 일일 박스오피스 출력 View
  @RequestMapping(value = "/kobis/dailyBoxOffice", method = RequestMethod.GET)
  public String dailyBoxOfficeView() throws Exception {
    return "kobis/dailyBoxOffice";
  }

  // 영화진흥위원회 일일 박스오피스 데이터 가져오기
  @ResponseBody
  @RequestMapping(value = "/kobis/dailyBoxOffice", method = RequestMethod.POST)
  public Object getDailyBoxOfficeProcess(@RequestParam("targetDt")String targetDt) throws Exception {
//    String url = "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" + targetDt;

    // 위의 @Value 어노테이션을 통해 데이터를 저장한 변수 사용
    String url = serviceUrl + "?key=" + serviceKey + "&targetDt=" + targetDt;

    List<DailyBoxOfficeDTO> dailyBoxOfficeDTOList = parserService.getDailyBoxOfficeList(url);

    return dailyBoxOfficeDTOList;
  }

  @RequestMapping(value = "/project/view", method = RequestMethod.GET)
  public String view() throws Exception {
    return "project/view";
  }
}





















