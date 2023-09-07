package com.bitc.sequrityquiz.data.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "jpa_member")
@Getter
@Setter
@NoArgsConstructor
public class Member implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int memberIdx;

  @Column(unique = true)
  private String userId;

  @Column(nullable = false)
  private String pass;

  @Column(nullable = false)
  private String name;

  @CreatedDate
  @Column(nullable = false)
  private LocalDate regidate;

  @Builder
  public Member(String userId, String pass, String name, LocalDate regidate, String auth) {
    this.userId = userId;
    this.pass = pass;
    this.name = name;
    this.regidate = regidate;
  }



  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return pass;
  }

  @Override
  public String getUsername() {
    return userId;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
