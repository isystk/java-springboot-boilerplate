package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TUserOnetimeValid;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TUserOnetimeValidCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserOnetimeValidDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TUserOnetimeValid entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TUserOnetimeValid entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TUserOnetimeValid entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final TUserOnetimeValidCriteria criteria, final SelectOptions options, final Collector<TUserOnetimeValid, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<TUserOnetimeValid> findAll(TUserOnetimeValidCriteria criteria);

    /**
     * @param userId
     * @return the TUserOnetimeValid entity
     */
    @Select
    Optional<TUserOnetimeValid> selectById(Integer userId);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<TUserOnetimeValid> findOne(TUserOnetimeValidCriteria criteria);

}