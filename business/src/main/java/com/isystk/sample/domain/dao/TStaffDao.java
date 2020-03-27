package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.isystk.sample.domain.dto.StaffCriteria;
import com.isystk.sample.domain.entity.TStaff;

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
public interface TStaffDao {

    /**
     * @param staffId
     * @param version
     * @return the TStaff entity
     */
    @Select(ensureResult = true)
    TStaff selectByIdAndVersion(Integer staffId, Long version);

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
     * 担当者を取得します。
     *
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final StaffCriteria criteria, final SelectOptions options, final Collector<TStaff, ?, R> collector);

    /**
     * 担当者を1件取得します。
     *
     * @param id
     * @return
     */
    @Select
    Optional<TStaff> selectById(Long staffId);

    /**
     * 担当者を1件取得します。
     *
     * @param criteria
     * @return
     */
    @Select
    Optional<TStaff> select(StaffCriteria criteria);

}