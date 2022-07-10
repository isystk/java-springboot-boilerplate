package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.PasswordReset;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.PasswordResetCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface PasswordResetDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(PasswordReset entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(PasswordReset entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(PasswordReset entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final PasswordResetCriteria criteria, final SelectOptions options, final Collector<PasswordReset, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<PasswordReset> findAll(PasswordResetCriteria criteria);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<PasswordReset> findOne(PasswordResetCriteria criteria);

}