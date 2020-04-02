package com.isystk.sample.solr.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import com.isystk.sample.common.dto.Dto;

import lombok.Getter;
import lombok.Setter;

@SolrDocument(collection = "post")
@Getter
@Setter
public class SolrPost implements Dto {

	@Id
	@Indexed(name = "id")
	private String id;

	@Indexed(name = "post_id")
	private Integer postId;

	@Indexed(name = "user_id")
	private Integer userId;

	@Indexed(name = "title")
	private String title;

	@Indexed(name = "text")
	private String text;

	@Indexed(name = "image_id_list")
	private List<Integer> imageIdList;

	@Indexed(name = "tag_id_list")
	private List<Integer> tagIdList;

	@Indexed(name = "tag_name_list")
	private List<String> tagNameList;

	@Indexed(name = "regist_time")
	private LocalDateTime registTime;

}