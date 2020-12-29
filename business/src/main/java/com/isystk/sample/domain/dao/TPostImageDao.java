package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TPostImage;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TPostImageCriteria;

/**
 *
 */
@ConfigAutowireable
@Dao
public interface TPostImageDao {

  /**
   * @param entity
   * @return affected rows
   */
  @Insert
  int insert(TPostImage entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Update
  int update(TPostImage entity);

  /**
   * @param entity
   * @return affected rows
   */
  @Delete
  int delete(TPostImage entity);

  /**
   * @param criteria
   * @param options
   * @return
   */
  @Select(strategy = SelectType.COLLECT)
  <R> R findAll(final TPostImageCriteria criteria, final SelectOptions options,
      final Collector<TPostImage, ?, R> collector);

  /**
   * @param criteria
   * @return
   */
  @Select
  List<TPostImage> findAll(TPostImageCriteria criteria);

  /**
   * @param postId
   * @param imageId
   * @return the TPostImage entity
   */
  @Select
  Optional<TPostImage> selectById(Integer postId, Integer imageId);


  /**
   * @param criteria
   * @return
   */
  @Select
  Optional<TPostImage> findOne(TPostImageCriteria criteria);

}