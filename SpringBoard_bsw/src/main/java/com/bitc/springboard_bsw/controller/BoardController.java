package com.bitc.springboard_bsw.controller;

import com.bitc.springboard_bsw.dto.BoardDTO;
import com.bitc.springboard_bsw.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {
  @Autowired
  private BoardService boardService;

//  @RequestMapping(value = "/", method = RequestMethod.GET)
//  public String index() throws Exception {
//    return "index";
//  }

  @RequestMapping(value = "/board", method = RequestMethod.GET)
  public ModelAndView selectBoardList() throws Exception {
    ModelAndView mv = new ModelAndView("board/boardList");
    List<BoardDTO> boardList = boardService.selectBoardList();

    mv.addObject("boardList", boardList);
    return mv;
  }

  @RequestMapping(value = "/board/{idx}", method = RequestMethod.GET)
  public ModelAndView selectBoardDetail(@PathVariable("idx") int idx) throws Exception {
    ModelAndView mv = new ModelAndView("board/boardDetail");
    BoardDTO board = boardService.selectBoardDetail(idx);
    mv.addObject("board", board);

    return mv;
  }

  @RequestMapping(value = "/board/insert", method = RequestMethod.GET)
  public String insertView() throws Exception {
    return "board/boardWrite";
  }

  @RequestMapping(value = "/board/insert", method = RequestMethod.POST)
  public String insertBoard(BoardDTO board) throws Exception {
    boardService.insertBoard(board);

    return "redirect:/board";
  }

  @RequestMapping(value = "/board/{idx}", method = RequestMethod.PUT)
  public String updateBoard(BoardDTO board) throws Exception {
    boardService.updateBoard(board);

    return "redirect:/board";
  }

  @RequestMapping(value = "/board/{idx}", method = RequestMethod.DELETE)
  public String deleteBoard(@PathVariable("idx") int idx) throws Exception {
    boardService.deleteBoard(idx);

    return "redirect:/board";
  }

}
























