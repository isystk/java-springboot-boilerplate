package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Users;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.UsersCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface UsersDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Users entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final UsersCriteria criteria, final SelectOptions options, final Collector<Users, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Users> findAll(UsersCriteria criteria);

    /**
     * @param id
     * @return the Users entity
     */
    @Select
    Optional<Users> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Users entity
     */
    @Select(ensureResult = true)
    Optional<Users> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Users> findOne(UsersCriteria criteria);

}