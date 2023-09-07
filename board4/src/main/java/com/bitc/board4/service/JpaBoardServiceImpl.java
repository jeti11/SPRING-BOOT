package com.bitc.board4.service;

import com.bitc.board4.entity.JpaBoardEntity;
import com.bitc.board4.repository.JpaBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JpaBoardServiceImpl implements JpaBoardService {
  // 데이터베이스에 명령어를 전달하는 인터페이스
  // mybatis의 Mapper 인터페이스 및 xml 파일과 동일한 역할을 함
  private final JpaBoardRepository jpaBoardRepository;

  // 게시판 목록 가져오기, 쿼리 메소드를 사용하여 필요한 데이터 가져옴
  @Override
  public List<JpaBoardEntity> selectBoardList() throws Exception {
    return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
  }

  // 게시판 글 등록, 수정 하기
  @Override
  public void saveBoard(JpaBoardEntity jpaBoardEntity) throws Exception {
    // JpaRepository 에서 제공하는 save() 메소드를 사용하여 insert, update 기능을 구현
    jpaBoardRepository.save(jpaBoardEntity);
  }

  // 게시판 글 상세보기
  @Override
  public JpaBoardEntity selectBoardDetail(int boardIdx) throws Exception {
    // Optional : 데이터베이스에서 데이터를 조회 시 조회된 데이터가 null일 경우 이 null이 자바 언어의 null하고 의미가 조금 다름(데이터 베이스의 null은 특정 컬럼에 데이터가 없다는 의미로 사용되고, 자바의 null은 참조할 객체의 주소가 없다는 의미
    // 데이터베이스의 null을 자바 소스코드에 그대로 적용 시 원하지 않은 오류가 발생할 수 있음
    // 이러한 오류를 줄이기 위해 만들어진 타입이 Optional 타입임
    
    // 데이터가 있는지 없는지 확인할 수 있음
    Optional<JpaBoardEntity> optional = jpaBoardRepository.findById(boardIdx);

    // 조회된 데이터의 유무 판별
    if (optional.isPresent()) {
      // 반환할 데이터타입의 객체 생성, get() 메소드를 통해서 데이터를 가져옴
      JpaBoardEntity jpaBoardEntity = optional.get();
      // 조회수 1 올림
      jpaBoardEntity.setHitCnt(jpaBoardEntity.getHitCnt() + 1);
      // 조회수 1 올린 것을 DB에 저장
      jpaBoardRepository.save(jpaBoardEntity);

      // 조회된 내용 반환
      return jpaBoardEntity;
    }
    else {
      // 데이터 없을 시 강제 예외발생
      throw new NullPointerException();
    }
  }

  // 게시판 글 수정하기(글 등록과 중복되서 하나로 합침)


  // 게시판 글 삭제하기
  @Override
  public void deleteBoard(int boardIdx) throws Exception {
    // JpaRepository 에서 제공하는 deleteById() 메소드를 사용하여 delete 기능 구현
    jpaBoardRepository.deleteById(boardIdx);
  }
}
