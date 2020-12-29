package com.isystk.sample.common.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.common.dto.PageFactory;

public abstract class BaseRepository {

  @Autowired
  protected PageFactory pageFactory;
}
