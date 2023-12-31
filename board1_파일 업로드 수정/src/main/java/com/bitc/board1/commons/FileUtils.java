package com.bitc.board1.commons;

import com.bitc.board1.dto.BoardFileDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// @Bean과 @Component 는 동일하게 스프링 프레임워크에서 객체를 생성하여 사용하고 관리하는 라이브러리라는 의미의 어노테이션
// @Bean : 스프링 프레임워크 및 각종 서드파티 회사에서 제공하는 미리 생성해 놓은 라이브러리라는 뜻
// @Component : 사용자가 직접 생성한 라이브러리라는 뜻

// @Bean과 @Component 어노테이션을 붙이 것은 @AutoWired를 이용해서 객체 생성 및 관리할 수 있도록 할 수 있음

@Component
public class FileUtils {
  public List<BoardFileDTO> parseFileInfo(int boardIdx, MultipartHttpServletRequest uploadFiles) throws Exception {
    // 스프링 프레임워크가 제공하는 ObjectUtils를 사용하여 업로드된 파일이 있는지 확인, 없으면 true
    if (ObjectUtils.isEmpty(uploadFiles)) {
      // 파일이 없을 경우 바로 종료시킴
      return null;
    }
    // 업로드된 파일 정보가 있을 경우 파일 목록을 저장하기 위한 List 생성
    List<BoardFileDTO> fileList = new ArrayList<>();

    // 현재 시간 정보 패턴
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // 현재 타임존을 기준으로해서 현재 시간을 가져오기
    ZonedDateTime current = ZonedDateTime.now();
    // 폴더 경로 생성, 현재 타임존 기준 시간을 위에서 생성한 패턴에 맞게 설정하여 출력
//    String path = "images/" + current.format(format); // 해당 프로젝트 하위에 바로 "images폴더 생김

    // 현재 StandardServletMultipartResolver 사용 시 전체 경로가 아니면 파일 복사 시 오류가 발생함
    String path = "c:/upload/" + current.format(format);

    // 자바의 File 클래스 객체 생성, 위에서 생성한 경로로 생성
    File file = new File(path);
    // 지정한 경로가 존재하는지 확인, 있으면 true / 없으면 false
    if (file.exists() == false) {
      // 지정한 폴더가 있으면 넘어가고, 없으면 폴더를 새로 만듬
      file.mkdirs();
    }

    // 업로드된 파일 정보에서 파일 이름 목록 가져오기
    Iterator<String> iterator = uploadFiles.getFileNames();
    String newFileName; // 새 파일명을 저장할 변수
    String originalFileExtension; // 원본 파일의 확장자명을 저장할 변수
    String contentType; // 파일의 확장자명을 저장할 변수

    // 파일 이름 목록 중 다음 내용이 존재하는지 확인
    while (iterator.hasNext()) {
      // 파일 이름을 기준으로 해당 파일의 모든 정보를 가져와서 MultipartFile 타입의 List에 저장
      List<MultipartFile> list = uploadFiles.getFiles(iterator.next());

      // 파일 정보 목록에 있는 내용을 하나씩 출력
      for (MultipartFile multipartFile : list) {
        if (multipartFile.isEmpty() == false) {
          // 파일 정보가 존재하면 확장자명 가져오기
          contentType = multipartFile.getContentType();

          if (ObjectUtils.isEmpty(contentType)) {
            break;
          }
          else {
            // 확장자명에 따라 변수에 확장자명을 저장
            if (contentType.contains("image/jpeg")) {
              originalFileExtension = ".jpg";
            }
            else if (contentType.contains("image/png")) {
              originalFileExtension = ".png";
            }
            else if (contentType.contains("image/gif")) {
              originalFileExtension = ".gif";
            }
            else {
              break;
            }
          }
          // 현재 시간을 기준으로 새 파일명 생성, nanoTime() 사용하여 동일한 이름이 나올 수 없도록 함, 위에서 생성한 확장자명하고 문자열을 연결함
          newFileName = Long.toString(System.nanoTime()) + originalFileExtension;

          // DB에 저장하기 위한 BoardFileDTO 클래스 타입의 객체에 파일 정보 데이터 추가
          BoardFileDTO boardFile = new BoardFileDTO();
          boardFile.setBoardIdx(boardIdx); // 게시물 번호
          boardFile.setFileSize(multipartFile.getSize()); // 파일크기
          boardFile.setOriginalFileName(multipartFile.getOriginalFilename()); // 원본 파일명

          // 서버에 저장되는 파일 이름, 위에서 생성한 파일 저장 경로와 nanoTime()을 이용하여 생성한 파일 이름을 합하여 파일을 저장할 전체 경로를 생성
          boardFile.setStoredFileName(path + "/" + newFileName);

          // 맨 위에서 생성한 List<BoardFileDTO> 타입의 변수에 데이터 추가
          fileList.add(boardFile);

          // 자바의 File 클래스 객체를 방금 생성한 파일이름 및 경로로 생성함
          file = new File(path + "/" + newFileName);

          // 위까지의 내용은 메모리 안에서 동작되는 내용들임
          
          // 서버의 지정된 위치에 실제 파일을 복사함
          multipartFile.transferTo(file);
        }
      }
    }
    // 파일 정보 목록을 반환
    return fileList;
  }
}




























