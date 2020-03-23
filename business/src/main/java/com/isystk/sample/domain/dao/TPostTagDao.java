package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TPostTag;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TPostTagDao {

    /**
     * @param postId
     * @param postTagId
     * @return the TPostTag entity
     */
    @Select
    TPostTag selectById(Integer postId, Integer postTagId);

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
}