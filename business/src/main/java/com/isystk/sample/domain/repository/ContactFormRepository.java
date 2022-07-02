package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.ContactFormDao;
import com.isystk.sample.domain.dao.ContactFormImageDao;
import com.isystk.sample.domain.dto.ContactFormCriteria;
import com.isystk.sample.domain.dto.ContactFormImageCriteria;
import com.isystk.sample.domain.dto.ContactFormImageRepositoryDto;
import com.isystk.sample.domain.dto.ContactFormRepositoryDto;
import com.isystk.sample.domain.entity.ContactForm;
import com.isystk.sample.domain.entity.ContactFormImage;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * お問い合わせリポジトリ
 */
@Repository
public class ContactFormRepository extends BaseRepository {

  @Autowired
  ImageHelper imageHelper;

  @Autowired
  ContactFormDao contactFormDao;

  @Autowired
  ContactFormImageDao contactFormImageDao;

  /**
   * お問い合わせを複数取得します。
   *
   * @param criteria
   * @return
   */
  public List<ContactFormRepositoryDto> findAll(ContactFormCriteria criteria) {
    var options = createSelectOptions(1, Integer.MAX_VALUE);
    return convertDto(contactFormDao.findAll(criteria, options, toList()));
  }

  /**
   * お問い合わせを複数取得します。(ページングあり)
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<ContactFormRepositoryDto> findPage(ContactFormCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    var contactFormList =  convertDto(contactFormDao.findAll(criteria, options.count(), toList()));
    return pageFactory.create(contactFormList, pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param contactFormList
   * @return
   */
  private List<ContactFormRepositoryDto> convertDto(List<ContactForm> contactFormList) {

    // contactFormListからcontactFormIdのListを抽出
    List<BigInteger> contactFormIdList = contactFormList.stream().map(e -> e.getId())
        .collect(Collectors.toList());

    // contactFormId をkeyとした、contactFormImageListのMapを生成
    ContactFormImageCriteria contactFormImageCriteria = new ContactFormImageCriteria();
    contactFormImageCriteria.setContactFormIdIn(contactFormIdList);
    Map<BigInteger, List<ContactFormImageRepositoryDto>> contactFormImageMap =
        contactFormImageDao.findAll(contactFormImageCriteria)
        .stream()
            .map((e) -> {
              return ObjectMapperUtils.map(e, ContactFormImageRepositoryDto.class);
            })
            .collect(Collectors.groupingBy(ContactFormImageRepositoryDto::getId));

    // contactFormList を元に、contactFormDtoList へコピー
    var contactFormDtoList = ObjectMapperUtils
        .mapAll(contactFormList, ContactFormRepositoryDto.class)
    .stream().map((e) -> {
      e.setImageList(contactFormImageMap.get(e.getId()));
      return e;
    }).collect(toList());
    return contactFormDtoList;
  }

  /**
   * お問い合わせを取得します。
   *
   * @param criteria
   * @return
   */
  public Optional<ContactFormRepositoryDto> findOne(ContactFormCriteria criteria) {
    var data = contactFormDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(criteria + "のデータが見つかりません。"));
    return Optional.ofNullable(convertDto(Lists.newArrayList(data)).get(0));
  }

  /**
   * お問い合わせを取得します。
   *
   * @return
   */
  public ContactFormRepositoryDto findById(final BigInteger id) {
    var data = contactFormDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("contactForm_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * お問い合わせを追加します。
   *
   * @param contactFormDto
   * @return
   */
  public ContactForm create(final ContactFormRepositoryDto contactFormDto) {

    // 画像ファイルをS3にアップロードする
    contactFormDto.getImageList().stream()
            .forEach((e) -> {
              imageHelper.saveFileData(e.getContactImageData(), "/contacts", e.getContactImageName(), true);
            });

    val time = DateUtils.getNow();

    // お問い合わせテーブル
    val contactForm = ObjectMapperUtils.map(contactFormDto, ContactForm.class);
    contactForm.setCreatedAt(time); // 作成日
    contactForm.setUpdatedAt(time); // 更新日
    contactForm.setDeleteFlg(false); // 削除フラグ
    contactForm.setVersion(0L); // 楽観ロック改定番号
    contactFormDao.insert(contactForm);

    // お問い合わせ画像テーブル
    contactFormDto.getImageList().stream()
        .forEach((e) -> {
          val contactFormImage = new ContactFormImage();
          contactFormImage.setFileName(e.getContactImageName());
          contactFormImage.setCreatedAt(time); // 作成日
          contactFormImage.setUpdatedAt(time); // 更新日
          contactFormImage.setDeleteFlg(false); // 削除フラグ
          contactFormImage.setVersion(0L); // 楽観ロック改定番号
          contactFormImageDao.insert(contactFormImage);
        });

    return contactForm;
  }

  /**
   * お問い合わせを更新します。
   *
   * @param contactFormDto
   * @return
   */
  public ContactForm update(final ContactFormRepositoryDto contactFormDto) {
    // 画像ファイルをS3にアップロードする
    contactFormDto.getImageList().stream()
        .forEach((e) -> {
          imageHelper.saveFileData(e.getContactImageData(), "/contacts", e.getContactImageName(), true);
        });

    val time = DateUtils.getNow();

    val before = contactFormDao.selectById(contactFormDto.getId())
        .orElseThrow(
            () -> new NoDataFoundException("contactForm_id=" + contactFormDto.getId() + " のデータが見つかりません。"));

    // お問い合わせテーブル
    val contactForm = ObjectMapperUtils.mapExcludeNull(contactFormDto, before);
    contactForm.setUpdatedAt(time); // 更新日
    contactFormDao.update(contactForm);

    // お問い合わせ画像テーブル (Delete → Insert)
    ContactFormImageCriteria criteria = new ContactFormImageCriteria();
    criteria.setContactFormIdEq(contactFormDto.getId());
    var contactFormImageList = contactFormImageDao.findAll(criteria);
    contactFormImageList.stream().forEach((e) -> {
      contactFormImageDao.delete(e);
    });
    Optional.ofNullable(contactFormDto.getImageList()).orElse(Lists.newArrayList()).stream()
        .forEach((e) -> {
          val contactFormImage = new ContactFormImage();
          contactFormImage.setContactFormId(contactForm.getId());
          contactFormImage.setFileName(e.getContactImageName());
          contactFormImage.setCreatedAt(time); // 作成日
          contactFormImage.setUpdatedAt(time); // 更新日
          contactFormImage.setDeleteFlg(false); // 削除フラグ
          contactFormImage.setVersion(0L); // 楽観ロック改定番号
          contactFormImageDao.insert(contactFormImage);
        });

    return contactForm;
  }

  /**
   * お問い合わせを論理削除します。
   *
   * @return
   */
  public ContactForm delete(final BigInteger contactFormId) {
    val contactForm = contactFormDao.selectById(contactFormId)
        .orElseThrow(() -> new NoDataFoundException("contactForm_id=" + contactFormId + " のデータが見つかりません。"));

    val time = DateUtils.getNow();
    {
      contactForm.setUpdatedAt(time); // 削除日
      contactForm.setDeleteFlg(true); // 削除フラグ
      int updated = contactFormDao.update(contactForm);

      if (updated < 1) {
        throw new NoDataFoundException("contactForm_id=" + contactFormId + " は更新できませんでした。");
      }
    }

    ContactFormImageCriteria criteria = new ContactFormImageCriteria();
    criteria.setContactFormIdEq(contactFormId);
    var contactFormImageList = contactFormImageDao.findAll(criteria);
    contactFormImageList.stream().forEach((e) -> {
      e.setUpdatedAt(time); // 削除日
      e.setDeleteFlg(true); // 削除フラグ
      int updated = contactFormImageDao.update(e);

      if (updated < 1) {
        throw new NoDataFoundException("contactForm_id=" + contactFormId + " は更新できませんでした。");
      }
    });

    return contactForm;
  }
}
