package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.EmployEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployRepository extends JpaRepository<EmployEntity, Integer> {
  Optional<EmployEntity> findByEmpNo(int empNo);
  List<EmployEntity> findAllByFirstName(String firstName);


  @Query("SELECT e FROM EmployEntity AS e WHERE e.firstName = ?1")
  List<EmployEntity> querySelectFirstName(String name);

  @Query("SELECT e FROM EmployEntity AS e WHERE e.firstName = :firstName")
  List<EmployEntity> querySelectFirstName2(@Param("firstName") String firstName);
}
