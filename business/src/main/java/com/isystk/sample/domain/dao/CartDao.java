package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Cart;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.CartCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface CartDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Cart entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Cart entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Cart entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final CartCriteria criteria, final SelectOptions options, final Collector<Cart, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Cart> findAll(CartCriteria criteria);

    /**
     * @param id
     * @return the Cart entity
     */
    @Select
    Optional<Cart> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Cart entity
     */
    @Select(ensureResult = true)
    Optional<Cart> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Cart> findOne(CartCriteria criteria);

}