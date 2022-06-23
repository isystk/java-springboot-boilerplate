package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.ContactFormImages;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.ContactFormImagesCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface ContactFormImagesDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ContactFormImages entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ContactFormImages entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ContactFormImages entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final ContactFormImagesCriteria criteria, final SelectOptions options, final Collector<ContactFormImages, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<ContactFormImages> findAll(ContactFormImagesCriteria criteria);

    /**
     * @param id
     * @return the ContactFormImages entity
     */
    @Select
    Optional<ContactFormImages> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the ContactFormImages entity
     */
    @Select(ensureResult = true)
    Optional<ContactFormImages> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<ContactFormImages> findOne(ContactFormImagesCriteria criteria);

}