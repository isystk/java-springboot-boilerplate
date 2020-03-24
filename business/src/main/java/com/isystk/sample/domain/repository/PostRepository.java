package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.domain.dao.TPostDao;
import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.exception.NoDataFoundException;
import com.isystk.sample.domain.service.BaseRepository;

import lombok.val;

/**
 * 投稿リポジトリ
 */
@Repository
public class PostRepository extends BaseRepository {

    @Autowired
    TPostDao tPostDao;

    /**
     * 投稿を複数取得します。
     *
     * @param criteria
     * @param pageable
     * @return
     */
    public Page<TPost> findAll(PostCriteria criteria, Pageable pageable) {
        // ページングを指定する
        val options = createSelectOptions(pageable).count();
        val data = tPostDao.selectAll(criteria, options, toList());
        return pageFactory.create(data, pageable, options.getCount());
    }

    /**
     * 投稿を取得します。
     *
     * @param criteria
     * @return
     */
    public Optional<TPost> findOne(PostCriteria criteria) {
        return tPostDao.select(criteria);
    }

    /**
     * 投稿を取得します。
     *
     * @return
     */
    public TPost findById(final Long id) {
        return tPostDao.selectById(id).orElseThrow(() -> new NoDataFoundException("post_id=" + id + " のデータが見つかりません。"));
    }

    /**
     * 投稿を追加します。
     *
     * @param item
     * @return
     */
    public TPost create(final TPost item) {
        // 1件登録
    	tPostDao.insert(item);

        return item;
    }

    /**
     * 投稿を更新します。
     *
     * @param item
     * @return
     */
    public TPost update(final TPost item) {
        // 1件更新
        int updated = tPostDao.update(item);

        if (updated < 1) {
            throw new NoDataFoundException("post_id=" + item.getPostId() + " のデータが見つかりません。");
        }

        return item;
    }

    /**
     * 投稿を論理削除します。
     *
     * @return
     */
    public TPost delete(final Long id) {
        val staff = tPostDao.selectById(id)
                .orElseThrow(() -> new NoDataFoundException("post_id=" + id + " のデータが見つかりません。"));

        int updated = tPostDao.delete(staff);

        if (updated < 1) {
            throw new NoDataFoundException("post_id=" + id + " は更新できませんでした。");
        }

        return staff;
    }
}
