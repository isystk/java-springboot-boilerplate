package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import com.isystk.sample.domain.entity.MMailTemplate;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@ConfigAutowireable
@Dao
public interface MMailTemplateDao {

    /**
     * @param mailTemplateId
     * @return the MMailTemplate entity
     */
    @Select
    MMailTemplate selectById(Integer mailTemplateId);

    /**
     * @param mailTemplateId
     * @param version
     * @return the MMailTemplate entity
     */
    @Select(ensureResult = true)
    MMailTemplate selectByIdAndVersion(Integer mailTemplateId, Long version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(MMailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(MMailTemplate entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(MMailTemplate entity);
}