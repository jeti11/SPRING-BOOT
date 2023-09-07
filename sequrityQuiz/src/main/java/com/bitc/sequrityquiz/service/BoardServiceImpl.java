package com.bitc.sequrityquiz.service;

import com.bitc.sequrityquiz.data.entity.Board;
import com.bitc.sequrityquiz.data.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

  private final BoardRepository boardRepository;

  @Override
  public List<Board> getBoardList() throws Exception {
    List<Board> boardList = boardRepository.findAll();

    return boardList;
  }

  @Override
  public Board getBoardDetail(int boardIdx) throws Exception {
    Optional<Board> optional = boardRepository.findById(boardIdx);
    if (optional.isPresent()) {
      Board board = optional.get();
      board.setHitCnt(board.getHitCnt() + 1);
      return board;
    }
    else {
      throw new NullPointerException();
    }
  }


}
