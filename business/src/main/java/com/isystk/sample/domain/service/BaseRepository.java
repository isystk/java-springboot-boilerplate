package com.isystk.sample.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.isystk.sample.domain.dto.common.PageFactory;

public abstract class BaseRepository {

    @Autowired
    protected PageFactory pageFactory;
}
