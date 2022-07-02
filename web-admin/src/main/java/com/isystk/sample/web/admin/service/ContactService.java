package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dto.ContactFormCriteria;
import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.domain.entity.ContactForm;
import com.isystk.sample.domain.repository.ContactFormRepository;
import com.isystk.sample.web.admin.dto.ContactSearchConditionDto;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ContactService extends BaseTransactionalService {

  @Autowired
  ImageHelper imageHelper;

  @Autowired
  ContactFormRepository contactRepository;

  /**
   * お問い合わせを複数取得します。
   *
   * @param dto
   * @return
   */
  public List<ContactFormRepositoryDto> findAll(ContactSearchConditionDto dto) {
    return contactRepository.findAll(dtoToCriteria(dto));
  }

  /**
   * お問い合わせを複数取得します。(ページングあり)
   *
   * @param dto
   * @param pageable
   * @return
   */
  public Page<ContactFormRepositoryDto> findPage(ContactSearchConditionDto dto, Pageable pageable) {
    return contactRepository.findPage(dtoToCriteria(dto), pageable);
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private ContactFormCriteria dtoToCriteria(
      ContactSearchConditionDto dto) {
    // 入力値を詰め替える
    ContactFormCriteria criteria = new ContactFormCriteria();
    criteria.setYourNameLike(dto.getUserName());
    if (dto.getCreatedAtFrom() != null) {
      criteria.setCreatedAtGe(dto.getCreatedAtFrom().atStartOfDay());
    }
    if (dto.getCreatedAtTo() != null) {
      criteria.setCreatedAtLe(dto.getCreatedAtTo().atTime(LocalTime.MAX));
    }
    criteria.setDeleteFlgFalse(true);
    criteria.setOrderBy("order by updated_at desc");
    return criteria;
  }

  /**
   * お問い合わせを取得します。
   *
   * @param contactId
   * @return
   */
  public ContactFormRepositoryDto findById(BigInteger contactId) {
    // 1件取得する
    val contact = contactRepository.findById(contactId);

    Optional.ofNullable(contact.getImageList()).orElse(Lists.newArrayList()).stream()
        .map((e) -> {
          String imageData = imageHelper.getImageData("/contacts", e.getFileName());
          e.setContactImageData(imageData);
          e.setContactImageName(e.getFileName());
          return e;
        });

    return contact;
  }


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

  /**
   * お問い合わせを更新します。
   *
   * @param contactDto 
   * @return
   */
  public ContactForm update(final ContactFormRepositoryDto contactDto) {
    Assert.notNull(contactDto, "input must not be null");
    return contactRepository.update(contactDto);
  }

  /**
   * お問い合わせを論理削除します。
   *
   * @return
   */
  public ContactForm delete(final BigInteger id) {
    Assert.notNull(id, "id must not be null");
    return contactRepository.delete(id);
  }
}
