package com.bitc.sequrityquiz.controller;

import com.bitc.sequrityquiz.data.dto.AddMemberRequest;
import com.bitc.sequrityquiz.data.entity.Board;
import com.bitc.sequrityquiz.service.BoardService;
import com.bitc.sequrityquiz.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/quiz")
public class quizController {

  private final MemberService memberService;
  private final BoardService boardService;


  @RequestMapping("/index")
  public String index() throws Exception {
    return "index";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST)
  public String signup(AddMemberRequest member) throws Exception {
    memberService.save(member);
    return "redirect:/login";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public String signup() throws Exception {
    return "signup";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() throws Exception {
    return "login";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    new SecurityContextLogoutHandler().logout(req, resp, SecurityContextHolder.getContext()
      .getAuthentication());

    return "redirect:/logout";
  }

  // ------------------- 보드 관련 -----------------------

  @RequestMapping(value = "/boardList", method = RequestMethod.GET)
  public ModelAndView boardList() throws Exception {
    ModelAndView mv = new ModelAndView("boardList");

    List<Board> boardList = boardService.getBoardList();
    mv.addObject("boardList", boardList);

    return mv;
  }

  @RequestMapping(value = "/boardDetail/{boardIdx}", method = RequestMethod.GET)
  public ModelAndView boardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
    ModelAndView mv = new ModelAndView("boardDetail");

    Board board = boardService.getBoardDetail(boardIdx);
    mv.addObject("board", board);

    return mv;
  }



}
























