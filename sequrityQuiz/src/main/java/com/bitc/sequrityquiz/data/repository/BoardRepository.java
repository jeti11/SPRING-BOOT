package com.bitc.sequrityquiz.data.repository;

import com.bitc.sequrityquiz.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {


}
