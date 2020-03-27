package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.entity.TUser;

import java.util.Optional;
import java.util.stream.Collector;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserDao {

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

    /**
     * ユーザーを取得します。
     *
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final UserCriteria criteria, final SelectOptions options, final Collector<TUser, ?, R> collector);

    /**
     * ユーザーを1件取得します。
     *
     * @param id
     * @return
     */
    @Select
    Optional<TUser> selectById(Integer userId);

    /**
     * ユーザーを1件取得します。
     *
     * @param criteria
     * @return
     */
    @Select
    Optional<TUser> select(UserCriteria criteria);

}