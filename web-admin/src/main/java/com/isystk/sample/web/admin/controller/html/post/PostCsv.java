package com.isystk.sample.web.admin.controller.html.post;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true) // 定義されていないプロパティを無視してマッピングする
@JsonPropertyOrder({"投稿ID", "ユーザーID", "タイトル"}) // CSVのヘッダ順
@Getter
@Setter
public class PostCsv implements Serializable {

  private static final long serialVersionUID = -1883999589975469540L;

  @JsonProperty("投稿ID")
  String postId;

  @JsonProperty("ユーザーID")
  String userId;

  @JsonProperty("タイトル")
  String title;

}
