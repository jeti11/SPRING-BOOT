package com.bitc.springboard_bsw.service;

import com.bitc.springboard_bsw.dto.BoardDTO;
import com.bitc.springboard_bsw.mapper.BoardMapper;
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
  public BoardDTO selectBoardDetail(int idx) throws Exception {
    boardMapper.updateHitCnt(idx);
    BoardDTO board = boardMapper.selectBoardDetail(idx);

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
  public void deleteBoard(int idx) throws Exception {
    boardMapper.deleteBoard(idx);
  }

}
