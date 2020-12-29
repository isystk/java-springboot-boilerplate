package com.isystk.sample.solr.dto;

import com.isystk.sample.common.dto.Dto;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.LocalDateTime;
import java.util.List;

@SolrDocument(collection = "post")
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

  public String getId() {
    return this.id;
  }

  public Integer getPostId() {
    return this.postId;
  }

  public Integer getUserId() {
    return this.userId;
  }

  public String getTitle() {
    return this.title;
  }

  public String getText() {
    return this.text;
  }

  public List<Integer> getImageIdList() {
    return this.imageIdList;
  }

  public List<Integer> getTagIdList() {
    return this.tagIdList;
  }

  public List<String> getTagNameList() {
    return this.tagNameList;
  }

  public LocalDateTime getRegistTime() {
    return this.registTime;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setPostId(Integer postId) {
    this.postId = postId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setImageIdList(List<Integer> imageIdList) {
    this.imageIdList = imageIdList;
  }

  public void setTagIdList(List<Integer> tagIdList) {
    this.tagIdList = tagIdList;
  }

  public void setTagNameList(List<String> tagNameList) {
    this.tagNameList = tagNameList;
  }

  public void setRegistTime(LocalDateTime registTime) {
    this.registTime = registTime;
  }
}