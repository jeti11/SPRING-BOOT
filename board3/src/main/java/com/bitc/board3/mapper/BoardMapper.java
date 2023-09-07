package com.bitc.board3.mapper;

import com.bitc.board3.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
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

  // 게시물 조회수 업데이트
  void updateHitCount(int boardIdx) throws Exception;
}
