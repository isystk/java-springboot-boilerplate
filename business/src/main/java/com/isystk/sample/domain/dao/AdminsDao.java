package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;
import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.Admins;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.AdminsCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface AdminsDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Admins entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Admins entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Admins entity);

    /**
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R findAll(final AdminsCriteria criteria, final SelectOptions options, final Collector<Admins, ?, R> collector);

    /**
     * @param criteria
     * @return
     */
    @Select
    List<Admins> findAll(AdminsCriteria criteria);

    /**
     * @param id
     * @return the Admins entity
     */
    @Select
    Optional<Admins> selectById(Long id);

    /**
     * @param id
     * @param version
     * @return the Admins entity
     */
    @Select(ensureResult = true)
    Optional<Admins> selectByIdAndVersion(Long id, Long version);


    /**
     * @param criteria
     * @return
     */
    @Select
    Optional<Admins> findOne(AdminsCriteria criteria);

}