package com.isystk.sample.domain.dao;

import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Admin;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.AdminCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface AdminDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Admin entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Admin entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Admin entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final AdminCriteria criteria, final SelectOptions options, final Collector<Admin, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Admin> findAll(AdminCriteria criteria);

    /**
     * @param id
     * @return the Admin entity
     */
    @Select
    Optional<Admin> selectById(Long id);

    /**
     * @param id
     * @param version
     * @return the Admin entity
     */
    @Select(ensureResult = true)
    Optional<Admin> selectByIdAndVersion(Long id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Admin> findOne(AdminCriteria criteria);

}