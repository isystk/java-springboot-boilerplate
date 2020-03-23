package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.MPostTag;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface MPostTagDao {

    /**
     * @param postTagId
     * @return the MPostTag entity
     */
    @Select
    MPostTag selectById(Integer postTagId);

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
}