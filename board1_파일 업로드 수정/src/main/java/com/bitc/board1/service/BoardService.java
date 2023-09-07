package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDTO;
import com.bitc.board1.dto.BoardFileDTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {
  // 게시판 글 목록 보기
  List<BoardDTO> selectBoardList() throws Exception;

  // 게시판 글 상세 보기
  BoardDTO selectBoardDetail(int boardIdx) throws Exception;

  // 게시판 글 등록
  // 업로드된 파일 정보 확인을 위한 MultipartHttpServletRequest 타입의 매개변수 추가
  void insertBoard(BoardDTO board, MultipartHttpServletRequest multiPart) throws Exception;

  // 게시판 글 수정
  void updateBoard(BoardDTO board) throws Exception;

  // 게시판 글 삭제
  void deleteBoard(int boardIdx) throws Exception;

  // 다운로드할 파일 가져오기
  BoardFileDTO selectBoardFileInfo(int idx, int boardIdx) throws Exception;
}
