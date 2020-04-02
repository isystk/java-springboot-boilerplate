package com.isystk.sample.batch.jobs.solrRegist;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.isystk.sample.batch.item.ItemPosition;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SolrRegistPostDto implements ItemPosition {

	@NotNull
	Integer postId;

	@NotNull
	Integer userId;

	@NotEmpty
	String title;

	@NotEmpty
	String text;

	@NotEmpty
	LocalDateTime registTime;

	// 取り込み元ファイル
	String sourceName;

	int position;
}
