package com.bitc.board1.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

// @Configuration : 해당 클래스가 설정 관련 파일임을 나타내는 어노테이션
// @PropertySource : 지정한 파일의 내용을 가져와서 사용하는 어노테이션, 해당 어노테이션을 추가하여 여러개의 설정 파일을 로드하여 사용할 수 있음
@Configuration 
@PropertySource("classpath:/application.properties") // application.properties 파일의 내용을 가져와서 사용함
public class DatabaseConfiguration {
  
  // @Autowired : 해당 객체를 스프링 프레임워크가 대신 생성하고 관리하도록 하는 어노테이션
  @Autowired
  private ApplicationContext applicationContext;


  // @ConfigurationProperties : 지정한 이름의 설정 내용을 가져와서 사용하는 어노테이션
  // prefix : application.properties에서 지정한 접두사의 설정 내용을 가져옴
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  public HikariConfig hikariConfig() {
    // @ConfigurationProperties 어노테이션을 사용하여 spring.datasource.hikari 이름을 가지고 있는 설정 내용을 모두 가져와서 Hikari CP의 설정 클래스 객체 생성함
    return new HikariConfig();
  }

  // 위의 hikariConfig() 메소드를 사용하여 생성된 Hikari CP의 설정 내용을 사용하여 데이터베이스를 연결함
  @Bean
  public DataSource dataSource() throws Exception {
    DataSource dataSource = new HikariDataSource(hikariConfig());
    System.out.println(dataSource.toString());
    return dataSource;
  }

  // 실제 데이터 베이스를 사용하기 위한 커넥션 풀 생성
  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);
    
    // mybatis orm을 통한 sql 명령어가 있는 xml 파일 로드
    sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/sql-*.xml"));
    // mybatis orm 사용 설정
    sqlSessionFactoryBean.setConfiguration(mybatisConfig());

    return sqlSessionFactoryBean.getObject();
  }


  @Bean
  public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }


  // application.properties 파일의 설정 내용 중 mybatis.configuration 이름으로 구성된 설정 내용을 모두 가져옴
  @Bean
  @ConfigurationProperties(prefix = "mybatis.configuration")
  public org.apache.ibatis.session.Configuration mybatisConfig() {
    return new org.apache.ibatis.session.Configuration();
  }


}



























