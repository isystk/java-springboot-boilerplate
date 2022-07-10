package com.isystk.sample.web.front.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isystk.sample.common.dto.Dto;
import java.math.BigInteger;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthUserDto implements Dto {

  /** ユーザID */
  BigInteger id;

  /** プロバイダID */
  @JsonProperty("provider_id")
  String providerId;

  /** プロバイダ名 */
  @JsonProperty("provider_name")
  String providerName;

  /** ユーザ名 */
  String name;

  /** メールアドレス */
  String email;

  /** メール検証日時 */
  @JsonProperty("email_verified_at")
  LocalDateTime emailVerifiedAt;

  /** 登録日時 */
  @JsonProperty("created_at")
  LocalDateTime createdAt;

  /** 更新日時 */
  @JsonProperty("updated_at")
  LocalDateTime updatedAt;

  /**
   * セッションID
   */
  @JsonProperty("session_id")
  String sessionId;

}
