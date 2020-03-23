package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TImage;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TImageDao {

    /**
     * @param imageId
     * @return the TImage entity
     */
    @Select
    TImage selectById(Integer imageId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TImage entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TImage entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TImage entity);
}