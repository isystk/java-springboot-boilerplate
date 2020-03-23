package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TPostImage;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TPostImageDao {

    /**
     * @param postId
     * @param imageId
     * @return the TPostImage entity
     */
    @Select
    TPostImage selectById(Integer postId, Integer imageId);

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
}