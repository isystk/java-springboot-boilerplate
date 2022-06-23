package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.PasswordResets;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.PasswordResetsCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface PasswordResetsDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(PasswordResets entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(PasswordResets entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(PasswordResets entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final PasswordResetsCriteria criteria, final SelectOptions options, final Collector<PasswordResets, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<PasswordResets> findAll(PasswordResetsCriteria criteria);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<PasswordResets> findOne(PasswordResetsCriteria criteria);

}