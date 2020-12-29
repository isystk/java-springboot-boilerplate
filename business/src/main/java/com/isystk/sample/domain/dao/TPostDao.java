package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TPost;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TPostCriteria;

/**
 *
 */
@ConfigAutowireable
@Dao
public interface TPostDao {

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
   * @param criteria
   * @param options
   * @return
   */
  @Select(strategy = SelectType.COLLECT)
  <R> R findAll(final TPostCriteria criteria, final SelectOptions options,
      final Collector<TPost, ?, R> collector);

  /**
   * @param criteria
   * @return
   */
  @Select
  List<TPost> findAll(TPostCriteria criteria);

  /**
   * @param postId
   * @return the TPost entity
   */
  @Select
  Optional<TPost> selectById(Integer postId);

  /**
   * @param postId
   * @param version
   * @return the TPost entity
   */
  @Select(ensureResult = true)
  Optional<TPost> selectByIdAndVersion(Integer postId, Long version);


  /**
   * @param criteria
   * @return
   */
  @Select
  Optional<TPost> findOne(TPostCriteria criteria);

}