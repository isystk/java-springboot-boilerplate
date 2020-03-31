package com.isystk.sample.solr.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Getter;
import lombok.Setter;

@SolrDocument(collection = "post")
@Getter
@Setter
public class SolrPost {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "post_id", type = "long")
    private Integer postId;

    @Indexed(name = "user_id", type = "long")
    private Integer userId;

    @Indexed(name = "title", type = "string")
    private String title;

    @Indexed(name = "text", type = "string")
    private String text;

    @Indexed(name = "regist_time", type = "pdate")
    private LocalDateTime registTime;

}