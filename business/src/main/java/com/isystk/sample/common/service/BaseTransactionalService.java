package com.isystk.sample.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.isystk.sample.common.dto.PageFactory;

@Transactional(rollbackFor = Throwable.class)
public abstract class BaseTransactionalService extends BaseService {

	@Autowired
	protected PageFactory pageFactory;

}
