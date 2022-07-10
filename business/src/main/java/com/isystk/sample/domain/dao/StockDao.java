package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Stock;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.StockCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface StockDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Stock entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Stock entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Stock entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final StockCriteria criteria, final SelectOptions options, final Collector<Stock, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Stock> findAll(StockCriteria criteria);

    /**
     * @param id
     * @return the Stock entity
     */
    @Select
    Optional<Stock> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Stock entity
     */
    @Select(ensureResult = true)
    Optional<Stock> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Stock> findOne(StockCriteria criteria);

}