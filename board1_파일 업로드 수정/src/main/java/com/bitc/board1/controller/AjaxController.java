package com.bitc.board1.controller;

import com.bitc.board1.dto.AreaDTO;
import com.bitc.board1.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class AjaxController {
  @Autowired
  private AreaService areaService;

  // ajax를 사용하지 않는 계산 페이지
  @RequestMapping(value = "/ajax/nonAjaxCalView", method = RequestMethod.GET)
  public String nonAjaxCalView() throws Exception {
    return "/ajax/nonAjaxCalView";
  }

  // ajax를 사용하지 않는 계산 결과 페이지
  @RequestMapping(value = "/ajax/nonAjaxCalResult", method = RequestMethod.GET)
  public ModelAndView nonAjaxCalResult(@RequestParam("num1") int num1, @RequestParam int num2) throws Exception {
    ModelAndView mv = new ModelAndView("/ajax/nonAjaxCalResult");
    int result = num1 + num2;

    mv.addObject("num1", num1);
    mv.addObject("num2", num2);
    mv.addObject("result", result);
    return mv;
  }

  // ajax를 사용하는 계산 페이지
  @RequestMapping(value = "/ajax/ajaxCalView", method = RequestMethod.GET)
  public String ajaxCalView() throws Exception {
    return "/ajax/ajaxCalView";
  }


  // ajax를 사용하는 계산 프로세스
  @ResponseBody
  @RequestMapping(value = "/ajax/ajaxCalResult", method = RequestMethod.POST)
  // Object 반환타입으로 해놓으면 자동으로 json 타입으로 받음
  public Object ajaxCalResult(@RequestParam("num1") int num1, @RequestParam("num2") int num2) throws Exception {
    int result = num1 + num2;

    HashMap<String, String> mapResult = new HashMap<>();
    mapResult.put("result", "success");
    mapResult.put("value", String.valueOf(result));

    return mapResult;
  }

  @RequestMapping(value = "/ajax/selectBox", method = RequestMethod.GET)
  public String selectBox() throws Exception {
    return "/ajax/selectBox";
  }

  // @ResponseBody : 사용자 요청을 서버에서 받은 후 클라이언트로 응답할 때 view를 제외한 데이터만 전송하도록 하는 어노테이션 -> ajax 통신을 하는 경우는 @ResponseBody 반드시 붙여줘야 함
  @ResponseBody
  @RequestMapping(value = "/ajax/selectBox1", method = RequestMethod.POST)
  public Object selectBox1(@RequestParam String areaName) throws Exception {
    List<AreaDTO> areaList = new ArrayList<>();

    if (areaName.equals("서울")) {
      AreaDTO se1 = new AreaDTO();
      AreaDTO se2 = new AreaDTO();
      AreaDTO se3 = new AreaDTO();
      AreaDTO se4 = new AreaDTO();

      se1.setAreaName("강북구");
      se2.setAreaName("강남구");
      se3.setAreaName("강서구");
      se4.setAreaName("강동구");

      areaList.add(se1);
      areaList.add(se2);
      areaList.add(se3);
      areaList.add(se4);
    }
    else if (areaName.equals("대전")) {
      AreaDTO dj1 = new AreaDTO();
      AreaDTO dj2 = new AreaDTO();
      AreaDTO dj3 = new AreaDTO();
      AreaDTO dj4 = new AreaDTO();

      dj1.setAreaName("동구");
      dj2.setAreaName("중구");
      dj3.setAreaName("서구");
      dj4.setAreaName("유성구");

      areaList.add(dj1);
      areaList.add(dj2);
      areaList.add(dj3);
      areaList.add(dj4);
    }
    else if (areaName.equals("대구")) {
      AreaDTO dg1 = new AreaDTO();
      AreaDTO dg2 = new AreaDTO();
      AreaDTO dg3 = new AreaDTO();
      AreaDTO dg4 = new AreaDTO();

      dg1.setAreaName("달서구");
      dg2.setAreaName("달서군");
      dg3.setAreaName("수성구");
      dg4.setAreaName("중구");

      areaList.add(dg1);
      areaList.add(dg2);
      areaList.add(dg3);
      areaList.add(dg4);
    }
    else if (areaName.equals("부산")) {
      AreaDTO bs1 = new AreaDTO();
      AreaDTO bs2 = new AreaDTO();
      AreaDTO bs3 = new AreaDTO();
      AreaDTO bs4 = new AreaDTO();

      bs1.setAreaName("부산진구");
      bs2.setAreaName("해운대구");
      bs3.setAreaName("동래구");
      bs4.setAreaName("영도구");

      areaList.add(bs1);
      areaList.add(bs2);
      areaList.add(bs3);
      areaList.add(bs4);
    }
    return areaList;
  }

  @RequestMapping(value = "/ajax/quiz1", method = RequestMethod.GET)
  public String quiz1() throws Exception {
    return "/ajax/quiz1";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz1Process", method = RequestMethod.POST)
  public Object quiz1Process(@RequestParam int num1, @RequestParam int num2, @RequestParam String cal) throws Exception {
    int result = 0;
    if (cal.equals("+")) {
      result = num1 + num2;
    }
    else if (cal.equals("-")) {
      result = num1 - num2;
    }
    else if (cal.equals("*")) {
      result = num1 * num2;
    }
    else if (cal.equals("/")) {
      result = num1 / num2;
    }

    HashMap<String, String> quiz1Result = new HashMap<>();
    quiz1Result.put("result", "success");
    quiz1Result.put("value", String.valueOf(result));

    return quiz1Result;
  }

  @RequestMapping(value = "/ajax/quiz2", method = RequestMethod.GET)
  public String quiz2() throws Exception {
    return "/ajax/quiz2";
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz2Result", method = RequestMethod.POST)
  public Object quiz2Area(@RequestParam String areaName) throws Exception {
    List<AreaDTO> areaList = areaService.getDistrictList(areaName);

    return areaList;
  }

  @ResponseBody
  @RequestMapping(value = "/ajax/quiz2Result2", method = RequestMethod.POST)
  public Object quiz2Result2(@RequestParam String areaName) throws Exception {
    List<AreaDTO> areaList = areaService.getTownList(areaName);

    return areaList;
  }

}



















































