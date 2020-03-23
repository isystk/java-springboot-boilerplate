package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.SysConfig;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface SysConfigDao {

    /**
     * @param variable
     * @return the SysConfig entity
     */
    @Select
    SysConfig selectById(String variable);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(SysConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(SysConfig entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(SysConfig entity);
}