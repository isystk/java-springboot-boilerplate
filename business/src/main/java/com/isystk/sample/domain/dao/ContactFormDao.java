package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.ContactForm;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.ContactFormCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface ContactFormDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ContactForm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ContactForm entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ContactForm entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final ContactFormCriteria criteria, final SelectOptions options, final Collector<ContactForm, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<ContactForm> findAll(ContactFormCriteria criteria);

    /**
     * @param id
     * @return the ContactForm entity
     */
    @Select
    Optional<ContactForm> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the ContactForm entity
     */
    @Select(ensureResult = true)
    Optional<ContactForm> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<ContactForm> findOne(ContactFormCriteria criteria);

}