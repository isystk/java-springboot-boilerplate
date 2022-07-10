package com.isystk.sample.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Stripe用の支払情報DTO
 */
@Getter
@Setter
public class StripePaymentDto implements Dto {

  @JsonProperty("client_secret")
  String clientSecret;
}
