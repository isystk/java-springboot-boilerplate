package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Carts;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.CartsCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface CartsDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Carts entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Carts entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Carts entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final CartsCriteria criteria, final SelectOptions options, final Collector<Carts, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Carts> findAll(CartsCriteria criteria);

    /**
     * @param id
     * @return the Carts entity
     */
    @Select
    Optional<Carts> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Carts entity
     */
    @Select(ensureResult = true)
    Optional<Carts> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Carts> findOne(CartsCriteria criteria);

}