package com.bitc.sequrityquiz.service;

import com.bitc.sequrityquiz.data.entity.Board;

import java.util.List;

public interface BoardService {
  List<Board> getBoardList() throws Exception;

  Board getBoardDetail(int boardIdx) throws Exception;
}
