package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TUserOnetimePass;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TUserOnetimePassCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserOnetimePassDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TUserOnetimePass entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TUserOnetimePass entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TUserOnetimePass entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final TUserOnetimePassCriteria criteria, final SelectOptions options, final Collector<TUserOnetimePass, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<TUserOnetimePass> findAll(TUserOnetimePassCriteria criteria);

    /**
     * @param userId
     * @return the TUserOnetimePass entity
     */
    @Select
    Optional<TUserOnetimePass> selectById(Integer userId);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<TUserOnetimePass> findOne(TUserOnetimePassCriteria criteria);

}