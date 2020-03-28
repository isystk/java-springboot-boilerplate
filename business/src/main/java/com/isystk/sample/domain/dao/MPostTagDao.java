package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.MPostTag;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.MPostTagCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface MPostTagDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MPostTag entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MPostTag entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MPostTag entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final MPostTagCriteria criteria, final SelectOptions options, final Collector<MPostTag, ?, R> collector);

    /**
     * @param postTagId
     * @return the MPostTag entity
     */
    @Select
    Optional<MPostTag> selectById(Integer postTagId);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<MPostTag> select(MPostTagCriteria criteria);

}