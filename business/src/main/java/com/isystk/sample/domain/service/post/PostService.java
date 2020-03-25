package com.isystk.sample.domain.service.post;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.isystk.sample.domain.dto.PostCriteria;
import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.repository.PostRepository;
import com.isystk.sample.domain.service.BaseTransactionalService;

@Service
public class PostService extends BaseTransactionalService {

    @Autowired
    PostRepository postRepository;

    /**
     * 投稿を複数取得します。
     *
     * @param criteria
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true) // 読み取りのみの場合は指定する
    public Page<TPost> findAll(PostCriteria criteria, Pageable pageable) {
        Assert.notNull(criteria, "criteria must not be null");
        return postRepository.findAll(criteria, pageable);
    }

    /**
     * 投稿を取得します。
     *
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<TPost> findOne(PostCriteria criteria) {
        Assert.notNull(criteria, "criteria must not be null");
        return postRepository.findOne(criteria);
    }

    /**
     * 投稿を取得します。
     *
     * @return
     */
    @Transactional(readOnly = true)
    public TPost findById(final Integer id) {
        Assert.notNull(id, "id must not be null");
        return postRepository.findById(id);
    }

    /**
     * 投稿を追加します。
     *
     * @param input
     * @return
     */
    public TPost create(final TPost input) {
        Assert.notNull(input, "input must not be null");
        return postRepository.create(input);
    }

    /**
     * 投稿を更新します。
     *
     * @param input
     * @return
     */
    public TPost update(final TPost input) {
        Assert.notNull(input, "input must not be null");
        return postRepository.update(input);
    }

    /**
     * 投稿を論理削除します。
     *
     * @return
     */
    public TPost delete(final Integer id) {
        Assert.notNull(id, "id must not be null");
        return postRepository.delete(id);
    }
}
