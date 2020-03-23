package com.isystk.sample.web.admin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.isystk.sample.domain.dao.ItemDao;
import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.dto.staff.ItemCriteria;
import com.isystk.sample.domain.entity.Item;
import com.isystk.sample.domain.repository.ItemRepository;
import com.isystk.sample.domain.service.BaseTransactionalService;

@Service
public class ItemService extends BaseTransactionalService {

    @Autowired
    ItemRepository staffRepository;

    /**
     * 担当者を複数取得します。
     *
     * @param criteria
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true) // 読み取りのみの場合は指定する
    public Page<Item> findAll(ItemCriteria criteria, Pageable pageable) {
        Assert.notNull(criteria, "criteria must not be null");
        return staffRepository.findAll(criteria, pageable);
    }

    /**
     * 担当者を取得します。
     *
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<Item> findOne(ItemCriteria criteria) {
        Assert.notNull(criteria, "criteria must not be null");
        return staffRepository.findOne(criteria);
    }

    /**
     * 担当者を取得します。
     *
     * @return
     */
    @Transactional(readOnly = true)
    public Item findById(final Long id) {
        Assert.notNull(id, "id must not be null");
        return staffRepository.findById(id);
    }

    /**
     * 担当者を追加します。
     *
     * @param inputItem
     * @return
     */
    public Item create(final Item inputItem) {
        Assert.notNull(inputItem, "inputItem must not be null");
        return staffRepository.create(inputItem);
    }

    /**
     * 担当者を更新します。
     *
     * @param inputItem
     * @return
     */
    public Item update(final Item inputItem) {
        Assert.notNull(inputItem, "inputItem must not be null");
        return staffRepository.update(inputItem);
    }

    /**
     * 担当者を論理削除します。
     *
     * @return
     */
    public Item delete(final Long id) {
        Assert.notNull(id, "id must not be null");
        return staffRepository.delete(id);
    }
}
