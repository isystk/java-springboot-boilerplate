package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.ContactForms;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.ContactFormsCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface ContactFormsDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(ContactForms entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(ContactForms entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(ContactForms entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final ContactFormsCriteria criteria, final SelectOptions options, final Collector<ContactForms, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<ContactForms> findAll(ContactFormsCriteria criteria);

    /**
     * @param id
     * @return the ContactForms entity
     */
    @Select
    Optional<ContactForms> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the ContactForms entity
     */
    @Select(ensureResult = true)
    Optional<ContactForms> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<ContactForms> findOne(ContactFormsCriteria criteria);

}