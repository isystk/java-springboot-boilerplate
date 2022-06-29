package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.User;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.UserCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface UserDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(User entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final UserCriteria criteria, final SelectOptions options, final Collector<User, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<User> findAll(UserCriteria criteria);

    /**
     * @param id
     * @return the User entity
     */
    @Select
    Optional<User> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the User entity
     */
    @Select(ensureResult = true)
    Optional<User> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<User> findOne(UserCriteria criteria);

}