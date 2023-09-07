package com.bitc.jpatest.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "jpa_product")
@Getter
@Setter
// callSuper : 부모 클래스의 필드를 해당 클래스에 포함하는 역할을 하는 속성, 롬복에서 제공
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long number; // 상품 번호

  @Column(nullable = false)
  private String name; // 상품 이름

  @Column(nullable = false)
  private int price; // 상품 가격

  @Column(nullable = false)
  private int stock; // 상품 재고

  // 아래의 필드는 부모 클래스인 BaseEntity로 부터 상속받아 사용하기 때문에 삭제함
//  @Column(nullable = false)
//  private LocalDateTime createdAt = LocalDateTime.now(); // 등록 시간
//
//  private LocalDateTime updatedAt; // 최종 수정 시간
  
  
  // @OneToOne : 다른 Entity 객체를 필드(컬럼)으로 지정할 경우에 1:1 관계로 설정 시 사용하는 어노테이션
  // ex) 상품(1) : 상품상세(1) 관계 생각하면 됨
  //  ~mappedBy : @OneToOne 어노테이션 사용 시 메인이 되는 Entity에 설정, 값은 서브가 되는 Entity에서 필드로 지정한 이름을 써야 함, 양방향 매핑을 할 경우에만 메인에 @OneToOne(mappedBy)를 사용함
  //  ~optional : 서브가 되는 Entity의 @OneToOne 에 optional = false 사용 시 null을 허용하지 않음


  // @OneToMany : 다른 Entity 객체를 필드로 지정할 경우 1:N 관계로 설정 시 사용하는 어노테이션
  // ex) 게시판(1) : 댓글(N) 관계 생각하면 됨
  
  // @ManyToOne : 다른 Entity 객체를 필드로 지정할 경우 N:1 관계로 설정 시 사용하는 어노테이션
  // ex) 댓글(N) : 게시판(1) 관계 생각하면 됨
  
  // @ManyToMany : 다른 Entity 객체를 필드로 지정할 경우 N:N 관계로 설정 시 사용하는 어노테이션
  // 다대다 관계는 실제로 잘 사용안함

  // mappedBy 속성은 @OneToOne 어노테이션 사용 시 양방향 매핑이 아니면 사용하지 않아도 됨
  @OneToOne(mappedBy = "product")
  @ToString.Exclude // 동일한 컬럼을 메인측에 별도로 생성하지 않겠다
  private ProductDetailEntity productDetail;
  
  @ManyToOne
  @JoinColumn(name = "provider_id")
  @ToString.Exclude
  private ProviderEntity provider;
}















