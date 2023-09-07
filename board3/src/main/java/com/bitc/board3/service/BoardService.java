package com.bitc.board3.service;

import com.bitc.board3.dto.BoardDTO;

import java.util.List;

public interface BoardService {
  // 게시물 전체 목록 출력
  List<BoardDTO> selectBoardList() throws Exception;


  // 게시물 상세 내용 출력
  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  // 게시물 등록
  void insertBoard(BoardDTO board) throws Exception;

  // 게시물 수정
  void updateBoard(BoardDTO board) throws Exception;

  // 게시물 삭제
  void deleteBoard(int boardIdx) throws Exception;

}
