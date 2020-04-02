package com.isystk.sample.common.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageImpl<T> implements Page<T>, Serializable {

	private static final long serialVersionUID = -4365096766976038677L;

	List<T> data;

	long count = -1;

	int page = 1;

	int perpage = 10;

	int totalPages = -1;

	/**
	 * コンストラクタ
	 *
	 * @param data
	 * @param pageable
	 */
	public PageImpl(List<T> data, Pageable pageable, long count) {
		this.data = (data == null) ? Collections.emptyList() : data;
		this.count = count;
		this.page = pageable.getPage();
		this.perpage = pageable.getPerpage();
		this.totalPages = Math.max(1, (int) Math.ceil((double) count / perpage));
	}
}
