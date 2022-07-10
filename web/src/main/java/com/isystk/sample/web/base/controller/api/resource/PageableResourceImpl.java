package com.isystk.sample.web.base.controller.api.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isystk.sample.common.dto.Dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageableResourceImpl extends ResourceImpl implements PageableResource {

  @JsonProperty("current_page")
  int currentPage = 1;

  int total;

  public PageableResourceImpl() {
  }

  public PageableResourceImpl(List<? extends Dto> data, int currentPage, int total) {
    this.data = data;
    this.currentPage = currentPage;
    this.total = total;
  }
}
