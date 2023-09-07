package com.bitc.board3.controller;

import com.bitc.board3.dto.AddressDTO;
import com.bitc.board3.service.AddressService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardPageController {
  @Autowired
  private AddressService addressService;

  // required = 파라미터 값 여부 설정, true/false, true이면 파라미터 값이 반드시 존재해야 함, false이면 파라미터 값이 없어도 오류발생 X
  // required = false 사용 할 경우, defaultValue 속성 으로 지정한 파라미터값이 사용됨
  @RequestMapping("/page/addressList")
  public ModelAndView addressList(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
    ModelAndView mv = new ModelAndView("page/addressList");

    // 첫번째 매개변수는 Service 사용하여 DB에서 데이터 가져오기
    // 두번째 매개변수 : 한 페이지에 출력할 페이지버튼 수
    PageInfo<AddressDTO> p = new PageInfo<>(addressService.getAddressList(pageNum), 5);

    // PageInfo : PageHelper 라이브러리에서 제공하는 클래스

    // pageNum : 현재 페이지 번호
    // pageSize : 페이지 당 수량
    // size : 현재 페이지 수
    // startRow : 현재 페이지의 첫번째 요소가 데이터베이스에 있는 줄 번호
    // endRow : 현재 페이지의 마지막 요소가 데이터베이스에 있는 줄 번호
    // pages : 전체 페이지 수
    // prePage : 이전 페이지 번호
    // nextPage : 다음 페이지 번호
    // isFirstPage : 첫 페이지 여부 확인, true/false
    // isLastPage : 마지막 페이지 여부 확인, true/false
    // hasPreviousPage : 이전 페이지가 존재하는지 여부 확인, true/false
    // hasNextPage : 다음 페이지가 존재하는지 여부 확인, true/false
    // navigatePages : 네비게이션 페이지 번호
    // navigatePageNums : 전체 네비게이션 페이지 번호, 배열로 구성
    // navigateFirstPage : 네비게이션 바의 첫 페이지
    // navigateLastPage : 네비게이션 바의 마지막 페이지


    mv.addObject("addressList", p);

    return mv;
  }
}




















