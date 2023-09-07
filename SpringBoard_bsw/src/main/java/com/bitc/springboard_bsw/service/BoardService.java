package com.bitc.springboard_bsw.service;

import com.bitc.springboard_bsw.dto.BoardDTO;

import java.util.List;

public interface BoardService {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int idx) throws Exception;

  void insertBoard(BoardDTO board) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(int idx) throws Exception;
}
