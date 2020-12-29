package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 自動生成のため原則修正禁止!!
 */
@Entity
@Table(name = "t_user_onetime_valid")
@Getter
@Setter
public class TUserOnetimeValid extends DomaDtoImpl {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;


  /**
   * 会員ID
   */
  @Id
  @Column(name = "USER_ID")
  Integer userId;

  /**
   * ワンタイムキー
   */
  @Column(name = "ONETIME_KEY")
  String onetimeKey;

  /**
   * ワンタイム有効期限
   */
  @Column(name = "ONETIME_VALID_TIME")
  LocalDateTime onetimeValidTime;
}