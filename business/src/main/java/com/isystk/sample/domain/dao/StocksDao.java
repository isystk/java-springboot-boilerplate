package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Stocks;
import java.math.BigInteger;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.StocksCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface StocksDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Stocks entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Stocks entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Stocks entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final StocksCriteria criteria, final SelectOptions options, final Collector<Stocks, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Stocks> findAll(StocksCriteria criteria);

    /**
     * @param id
     * @return the Stocks entity
     */
    @Select
    Optional<Stocks> selectById(BigInteger id);

    /**
     * @param id
     * @param version
     * @return the Stocks entity
     */
    @Select(ensureResult = true)
    Optional<Stocks> selectByIdAndVersion(BigInteger id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Stocks> findOne(StocksCriteria criteria);

}