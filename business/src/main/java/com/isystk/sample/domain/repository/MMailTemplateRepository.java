package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.common.values.MailTemplateDiv;
import com.isystk.sample.domain.dao.MMailTemplateDao;
import com.isystk.sample.domain.dto.MMailTemplateCriteria;
import com.isystk.sample.domain.entity.MMailTemplate;
import com.isystk.sample.domain.repository.dto.MMailTemplateRepositoryDto;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;

/**
 * メールテンプレートマスタリポジトリ
 */
@Repository
public class MMailTemplateRepository extends BaseRepository {

  @Autowired
  MMailTemplateDao mMailTemplateDao;

  /**
   * メールテンプレートを複数取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<MMailTemplateRepositoryDto> findAll(MMailTemplateCriteria criteria,
      Pageable pageable) {
    var options = createSelectOptions(pageable);
    // ページングを指定する
    return pageFactory.create(convertDto(
        mMailTemplateDao.findAll(criteria,
            options.count(),
            toList()
        )), pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param mMailTemplateList
   * @return
   */
  private List<MMailTemplateRepositoryDto> convertDto(List<MMailTemplate> mMailTemplateList) {

    List<MMailTemplateRepositoryDto> list = ObjectMapperUtils
        .mapAll(mMailTemplateList, MMailTemplateRepositoryDto.class);
    list.stream()
        .forEach(dto -> {
          dto.setMailTemplateDiv(MailTemplateDiv.getValue(dto.getTemplateDiv()));
        });

    return list;
  }

  /**
   * メールテンプレートを取得します。
   *
   * @return
   */
  public MMailTemplateRepositoryDto findById(final Integer id) {
    var data = mMailTemplateDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("mail_tempate_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

}
