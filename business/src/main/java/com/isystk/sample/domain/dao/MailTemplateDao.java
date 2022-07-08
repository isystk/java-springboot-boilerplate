package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.MailTemplate;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.MailTemplateCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface MailTemplateDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MailTemplate entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final MailTemplateCriteria criteria, final SelectOptions options, final Collector<MailTemplate, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<MailTemplate> findAll(MailTemplateCriteria criteria);

    /**
     * @param mailTemplateId
     * @return the MailTemplate entity
     */
    @Select
    Optional<MailTemplate> selectById(Long mailTemplateId);

    /**
     * @param mailTemplateId
     * @param version
     * @return the MailTemplate entity
     */
    @Select(ensureResult = true)
    Optional<MailTemplate> selectByIdAndVersion(Long mailTemplateId, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<MailTemplate> findOne(MailTemplateCriteria criteria);

}