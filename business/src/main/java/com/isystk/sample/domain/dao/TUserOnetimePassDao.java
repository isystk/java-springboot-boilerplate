package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.TUserOnetimePass;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserOnetimePassDao {

    /**
     * @param userId
     * @return the TUserOnetimePass entity
     */
    @Select
    TUserOnetimePass selectById(Integer userId);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TUserOnetimePass entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TUserOnetimePass entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TUserOnetimePass entity);
}