package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.ContactFormImage;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.ContactFormImageCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface ContactFormImageDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ContactFormImage entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ContactFormImage entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ContactFormImage entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final ContactFormImageCriteria criteria, final SelectOptions options, final Collector<ContactFormImage, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<ContactFormImage> findAll(ContactFormImageCriteria criteria);

    /**
     * @param id
     * @return the ContactFormImage entity
     */
    @Select
    Optional<ContactFormImage> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the ContactFormImage entity
     */
    @Select(ensureResult = true)
    Optional<ContactFormImage> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<ContactFormImage> findOne(ContactFormImageCriteria criteria);

}