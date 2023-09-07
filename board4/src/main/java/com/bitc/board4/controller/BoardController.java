package com.bitc.board4.controller;

import com.bitc.board4.entity.JpaBoardEntity;
import com.bitc.board4.repository.JpaBoardRepository;
import com.bitc.board4.service.JpaBoardService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/jpa")
public class BoardController {
  private final JpaBoardService jpaBoardService;

  @RequestMapping("/")
  public String index() throws Exception {
    return "index";
  }

  // 게시판 목록 페이지
  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView selectBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/jpaBoardList");

    // 데이터 리스트를 데이터베이스 테이블을 나타내는 entity 클래스를 통해서 가져옴
    // Service 객체는 Mybatis 사용 시와 동일한 역할을 함
    List<JpaBoardEntity> boardList = jpaBoardService.selectBoardList();

    mv.addObject("boardList", boardList);

    return mv;
  }


  // 게시판 글쓰기 페이지
  @RequestMapping(value = "/board/write", method = RequestMethod.GET)
  public String insertBoardView() throws Exception {

    return "board/jpaInsertBoardView";
  }

  // 게시판 글쓰기 프로세스
  @RequestMapping(value = "/board/write", method = RequestMethod.POST)
  public String insertBoardProcess(JpaBoardEntity jpaBoardEntity) throws Exception {
    jpaBoardService.saveBoard(jpaBoardEntity);

    return "redirect:/jpa/board";
  }

  // 게시판 상세글 보기 페이지
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView selectBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("board/jpaBoardDetail");

    JpaBoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);

    mv.addObject("board", board);

    return mv;
  }

  // 게시판 글 수정하기
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
  public String updateBoard(JpaBoardEntity jpaBoardEntity) throws Exception {

    jpaBoardService.saveBoard(jpaBoardEntity);

    return "redirect:/jpa/board";
  }

  // 게시판 글 삭제하기
  @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
  public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
    jpaBoardService.deleteBoard(boardIdx);

    return "redirect:/jpa/board";
  }
}



























