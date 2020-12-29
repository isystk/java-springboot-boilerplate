package com.isystk.sample.web.front.controller.api.v1.post;

import static com.isystk.sample.common.Const.*;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;

import static com.isystk.sample.common.FrontUrl.API_V1_POSTS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.solr.dto.SolrPostCriteria;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.PageableResource;
import com.isystk.sample.web.base.controller.api.resource.PageableResourceImpl;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.front.dto.FrontPostDto;
import com.isystk.sample.web.front.service.PostService;

import lombok.val;

@RestController
@RequestMapping(path = API_V1_POSTS, produces = MediaType.APPLICATION_JSON_VALUE)
public class PostRestController extends AbstractRestController {

  @Autowired
  PostService postService;

  @Override
  public String getFunctionName() {
    return "API_POSTS";
  }

  /**
   * 投稿一覧を複数取得します。
   *
   * @param query
   * @param page
   * @return
   */
  @GetMapping
  public PageableResource index(PostRestForm query,
      @RequestParam(required = false, defaultValue = "1") int page) {

    // 入力値からDTOを作成する
    val criteria = ObjectMapperUtils.map(query, SolrPostCriteria.class);

    // 10件で区切って取得する
    Page<FrontPostDto> posts = postService.findSolrAll(criteria, Pageable.DEFAULT);

    PageableResource resource = ObjectMapperUtils.map(posts, PageableResourceImpl.class);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

  /**
   * 投稿詳細を取得します。
   *
   * @param postId
   * @return
   */
  @GetMapping(value = "/{postId}")
  public Resource show(@PathVariable Integer postId) {
    // 1件取得する
    var post = postService.findDataById(postId);

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(post.orElse(new FrontPostDto())));
    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

}
