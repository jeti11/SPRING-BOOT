package com.bitc.jpatest.data.entity;


import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "jpa_product_detail")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor

@Entity
@Table(name = "jpa_product_detail")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String description;

//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now();
//
//  private LocalDateTime updatedAt;

  @OneToOne
  // @JoinColumn : 외래키를 설정하는 어노테이션
  //  ~ name : 사용자가 원하는 이름으로 매핑, 생략 시 자동으로 입력됨
  //  ~ referencedColumnName : 외래키가 참조할 상대 테이블의 컬럼명을 지정
  //  ~ foreignKey : 외래키 생성 시 제약조건을 설정 (nullable, unique 등)
  @JoinColumn(name = "product_number")
  private ProductEntity product;
}
