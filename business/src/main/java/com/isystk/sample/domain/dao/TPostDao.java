package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.entity.TPost;

import java.util.Optional;
import java.util.stream.Collector;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TPostDao {

    /**
     * @param postId
     * @param version
     * @return the TPost entity
     */
    @Select(ensureResult = true)
    TPost selectByIdAndVersion(Integer postId, Long version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TPost entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TPost entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TPost entity);

    /**
     * 投稿を取得します。
     *
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final PostCriteria criteria, final SelectOptions options, final Collector<TPost, ?, R> collector);

    /**
     * 投稿を1件取得します。
     *
     * @param id
     * @return
     */
    @Select
    Optional<TPost> selectById(Integer postId);

    /**
     * 投稿を1件取得します。
     *
     * @param criteria
     * @return
     */
    @Select
    Optional<TPost> select(PostCriteria criteria);

}