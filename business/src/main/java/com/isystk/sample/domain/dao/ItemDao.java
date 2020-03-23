package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;

import com.isystk.sample.domain.dto.staff.ItemCriteria;
import com.isystk.sample.domain.dto.staff.StaffCriteria;
import com.isystk.sample.domain.entity.Item;
import com.isystk.sample.domain.entity.TStaff;
import com.isystk.sample.domain.entity.Item;

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
public interface ItemDao {
//
//    /**
//     * @param id
//     * @return the Item entity
//     */
//    @Select
//    Item selectById(Long id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Item entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Item entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Item entity);

    /**
     * 商品を取得します。
     *
     * @param criteria
     * @param options
     * @return
     */
    @Select(strategy = SelectType.COLLECT)
    <R> R selectAll(final ItemCriteria criteria, final SelectOptions options, final Collector<Item, ?, R> collector);

    /**
     * 商品を1件取得します。
     *
     * @param id
     * @return
     */
    @Select
    Optional<Item> selectById(Long id);

    /**
     * 商品を1件取得します。
     *
     * @param criteria
     * @return
     */
    @Select
    Optional<Item> select(ItemCriteria criteria);

}