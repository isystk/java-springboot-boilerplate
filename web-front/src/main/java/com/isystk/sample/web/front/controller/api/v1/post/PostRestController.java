package com.isystk.sample.web.front.controller.api.v1.post;

import static com.isystk.sample.web.base.WebConst.*;
import static com.isystk.sample.web.base.FrontUrl.*;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.solr.dto.SolrPost;
import com.isystk.sample.solr.dto.SolrPostCriteria;
import com.isystk.sample.solr.service.SolrPostService;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.PageableResource;
import com.isystk.sample.web.base.controller.api.resource.PageableResourceImpl;

import lombok.val;

@RestController
@RequestMapping(path = API_V1_POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class PostRestController extends AbstractRestController {

    @Autowired
    SolrPostService solrPostService;

    @Override
    public String getFunctionName() {
        return "API_POST";
    }

    /**
     * ユーザーを複数取得します。
     *
     * @param query
     * @param page
     * @return
     */
    @GetMapping
    public PageableResource index(PostQuery query, @RequestParam(required = false, defaultValue = "1") int page)
            throws IOException {
        // 入力値からDTOを作成する
        val criteria = modelMapper.map(query, SolrPostCriteria.class);

        // 10件で区切って取得する
        Page<SolrPost> posts = solrPostService.findAll(criteria, Pageable.DEFAULT);

        PageableResource resource = modelMapper.map(posts, PageableResourceImpl.class);
        resource.setMessage(getMessage(MESSAGE_SUCCESS));

        return resource;
    }

}
