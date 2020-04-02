package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.MMailTemplate;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.MMailTemplateCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface MMailTemplateDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MMailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MMailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MMailTemplate entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final MMailTemplateCriteria criteria, final SelectOptions options, final Collector<MMailTemplate, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<MMailTemplate> findAll(MMailTemplateCriteria criteria);

    /**
     * @param mailTemplateId
     * @return the MMailTemplate entity
     */
    @Select
    Optional<MMailTemplate> selectById(Integer mailTemplateId);

    /**
     * @param mailTemplateId
     * @param version
     * @return the MMailTemplate entity
     */
    @Select(ensureResult = true)
    Optional<MMailTemplate> selectByIdAndVersion(Integer mailTemplateId, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<MMailTemplate> findOne(MMailTemplateCriteria criteria);

}