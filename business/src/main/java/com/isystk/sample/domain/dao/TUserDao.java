package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserDao {

    /**
     * @param userId
     * @return the TUser entity
     */
    @Select
    TUser selectById(Integer userId);

    /**
     * @param userId
     * @param version
     * @return the TUser entity
     */
    @Select(ensureResult = true)
    TUser selectByIdAndVersion(Integer userId, Long version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TUser entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TUser entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TUser entity);
}