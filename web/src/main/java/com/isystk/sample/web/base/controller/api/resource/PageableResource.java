package com.isystk.sample.web.base.controller.api.resource;

public interface PageableResource extends Resource {

  int getCurrentPage();

  int getTotal();

  void setCurrentPage(int currentPage);

  void setTotal(int total);

  Boolean getResult();

  void setResult(Boolean result);
}
