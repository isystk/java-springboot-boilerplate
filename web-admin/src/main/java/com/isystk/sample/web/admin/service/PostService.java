package com.isystk.sample.web.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.entity.TPost;
import com.isystk.sample.domain.repository.TPostRepository;
import com.isystk.sample.domain.repository.dto.TPostRepositoryDto;

@Service
public class PostService extends BaseTransactionalService {

  @Autowired
  TPostRepository postRepository;

  /**
   * 投稿を追加します。
   *
   * @param tPostDto
   * @return
   */
  public TPost create(final TPostRepositoryDto tPostDto) {
    Assert.notNull(tPostDto, "input must not be null");
    return postRepository.create(tPostDto);
  }

  /**
   * 投稿を更新します。
   *
   * @param tPostDto
   * @return
   */
  public TPost update(final TPostRepositoryDto tPostDto) {
    Assert.notNull(tPostDto, "input must not be null");
    return postRepository.update(tPostDto);
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
