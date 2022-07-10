package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.OrderHistory;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.OrderHistoryCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface OrderHistoryDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(OrderHistory entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(OrderHistory entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(OrderHistory entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final OrderHistoryCriteria criteria, final SelectOptions options, final Collector<OrderHistory, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<OrderHistory> findAll(OrderHistoryCriteria criteria);

    /**
     * @param id
     * @return the OrderHistory entity
     */
    @Select
    Optional<OrderHistory> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the OrderHistory entity
     */
    @Select(ensureResult = true)
    Optional<OrderHistory> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<OrderHistory> findOne(OrderHistoryCriteria criteria);

}