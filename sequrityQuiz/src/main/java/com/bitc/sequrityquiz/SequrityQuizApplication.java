package com.bitc.sequrityquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SequrityQuizApplication {

  public static void main(String[] args) {
    SpringApplication.run(SequrityQuizApplication.class, args);
  }

}
