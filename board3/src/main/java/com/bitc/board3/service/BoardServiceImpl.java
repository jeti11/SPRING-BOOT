package com.bitc.board3.service;

import com.bitc.board3.dto.BoardDTO;
import com.bitc.board3.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardMapper boardMapper;

  @Override
  public List<BoardDTO> selectBoardList() throws Exception {
    List<BoardDTO> boardList = boardMapper.selectBoardList();
    return boardList;
  }

  @Override
  public BoardDTO selectBoardDetail(int boardIdx) throws Exception {
    boardMapper.updateHitCount(boardIdx);
    BoardDTO board = boardMapper.selectBoardDetail(boardIdx);
    return board;
  }

  @Override
  public void insertBoard(BoardDTO board) throws Exception {
    boardMapper.insertBoard(board);
  }

  @Override
  public void updateBoard(BoardDTO board) throws Exception {
    boardMapper.updateBoard(board);
  }

  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    boardMapper.deleteBoard(boardIdx);
  }
}
