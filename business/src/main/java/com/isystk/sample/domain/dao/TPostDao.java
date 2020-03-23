package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TPost;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TPostDao {

    /**
     * @param postId
     * @return the TPost entity
     */
    @Select
    TPost selectById(Integer postId);

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
}