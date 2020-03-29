package com.isystk.sample.solr.dto;


import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "post")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}