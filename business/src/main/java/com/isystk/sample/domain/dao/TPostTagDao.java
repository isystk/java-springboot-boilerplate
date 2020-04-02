package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TPostTag;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TPostTagCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface TPostTagDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TPostTag entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TPostTag entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TPostTag entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final TPostTagCriteria criteria, final SelectOptions options, final Collector<TPostTag, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<TPostTag> findAll(TPostTagCriteria criteria);

    /**
     * @param postId
     * @param postTagId
     * @return the TPostTag entity
     */
    @Select
    Optional<TPostTag> selectById(Integer postId, Integer postTagId);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<TPostTag> findOne(TPostTagCriteria criteria);

}