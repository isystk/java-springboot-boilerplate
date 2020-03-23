package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TUserOnetimeValid;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserOnetimeValidDao {

    /**
     * @param userId
     * @return the TUserOnetimeValid entity
     */
    @Select
    TUserOnetimeValid selectById(Integer userId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TUserOnetimeValid entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TUserOnetimeValid entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TUserOnetimeValid entity);
}