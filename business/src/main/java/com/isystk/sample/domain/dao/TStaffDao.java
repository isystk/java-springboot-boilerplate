package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TStaff;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TStaffCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface TStaffDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(TStaff entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(TStaff entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(TStaff entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final TStaffCriteria criteria, final SelectOptions options, final Collector<TStaff, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<TStaff> findAll(TStaffCriteria criteria);

    /**
     * @param staffId
     * @return the TStaff entity
     */
    @Select
    Optional<TStaff> selectById(Integer staffId);

    /**
     * @param staffId
     * @param version
     * @return the TStaff entity
     */
    @Select(ensureResult = true)
    Optional<TStaff> selectByIdAndVersion(Integer staffId, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<TStaff> findOne(TStaffCriteria criteria);

}