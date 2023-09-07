package com.bitc.springboard_bsw.mapper;

import com.bitc.springboard_bsw.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
  List<BoardDTO> selectBoardList() throws Exception;

  BoardDTO selectBoardDetail(int idx) throws Exception;

  void insertBoard(BoardDTO board) throws Exception;

  void updateBoard(BoardDTO board) throws Exception;

  void deleteBoard(int idx) throws Exception;

  void updateHitCnt(int idx) throws Exception;
}
