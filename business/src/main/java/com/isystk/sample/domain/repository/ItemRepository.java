package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.domain.dao.ItemDao;
import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.dto.staff.ItemCriteria;
import com.isystk.sample.domain.entity.Item;
import com.isystk.sample.domain.exception.NoDataFoundException;
import com.isystk.sample.domain.service.BaseRepository;

import lombok.val;

/**
 * 商品リポジトリ
 */
@Repository
public class ItemRepository extends BaseRepository {

    @Autowired
    ItemDao itemDao;

    /**
     * 商品を複数取得します。
     *
     * @param criteria
     * @param pageable
     * @return
     */
    public Page<Item> findAll(ItemCriteria criteria, Pageable pageable) {
        // ページングを指定する
        val options = createSelectOptions(pageable).count();
        val data = itemDao.selectAll(criteria, options, toList());
        return pageFactory.create(data, pageable, options.getCount());
    }

    /**
     * 商品を取得します。
     *
     * @param criteria
     * @return
     */
    public Optional<Item> findOne(ItemCriteria criteria) {
        return itemDao.select(criteria);
    }

    /**
     * 商品を取得します。
     *
     * @return
     */
    public Item findById(final Long id) {
        return itemDao.selectById(id).orElseThrow(() -> new NoDataFoundException("item_id=" + id + " のデータが見つかりません。"));
    }

    /**
     * 商品を追加します。
     *
     * @param inpuitem
     * @return
     */
    public Item create(final Item inpuitem) {
        // 1件登録
        itemDao.insert(inpuitem);

        return inpuitem;
    }

    /**
     * 商品を更新します。
     *
     * @param inpuitem
     * @return
     */
    public Item update(final Item inpuitem) {
        // 1件更新
        int updated = itemDao.update(inpuitem);

        if (updated < 1) {
            throw new NoDataFoundException("item_id=" + inpuitem.getId() + " のデータが見つかりません。");
        }

        return inpuitem;
    }

    /**
     * 商品を論理削除します。
     *
     * @return
     */
    public Item delete(final Long id) {
        val staff = itemDao.selectById(id)
                .orElseThrow(() -> new NoDataFoundException("item_id=" + id + " のデータが見つかりません。"));

        int updated = itemDao.delete(staff);

        if (updated < 1) {
            throw new NoDataFoundException("item_id=" + id + " は更新できませんでした。");
        }

        return staff;
    }
}
