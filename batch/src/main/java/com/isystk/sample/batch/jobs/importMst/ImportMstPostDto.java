package com.isystk.sample.batch.jobs.importMst;

import javax.validation.constraints.NotEmpty;

import com.isystk.sample.batch.item.ItemPosition;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImportMstPostDto implements ItemPosition {

  // タグID
  @NotEmpty
  String postTagId;

  // タグ名称
  @NotEmpty
  String name;

  // 取り込み元ファイル
  String sourceName;

  int position;
}
