package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Orders;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.OrdersCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface OrdersDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Orders entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Orders entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Orders entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final OrdersCriteria criteria, final SelectOptions options, final Collector<Orders, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Orders> findAll(OrdersCriteria criteria);

    /**
     * @param id
     * @return the Orders entity
     */
    @Select
    Optional<Orders> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Orders entity
     */
    @Select(ensureResult = true)
    Optional<Orders> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Orders> findOne(OrdersCriteria criteria);

}