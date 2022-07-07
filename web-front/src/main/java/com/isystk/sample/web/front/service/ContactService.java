package com.isystk.sample.web.front.service;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.domain.entity.ContactForm;
import com.isystk.sample.domain.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ContactService extends BaseTransactionalService {

  @Autowired
  ContactFormRepository contactRepository;

  /**
   * お問い合わせを追加します。
   *
   * @param contactDto 
   * @return
   */
  public ContactForm create(final ContactFormRepositoryDto contactDto) {
    Assert.notNull(contactDto, "input must not be null");
    return contactRepository.create(contactDto);
  }

}
