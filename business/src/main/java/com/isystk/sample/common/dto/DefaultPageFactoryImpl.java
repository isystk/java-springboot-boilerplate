package com.isystk.sample.common.dto;

import java.util.List;

/**
 * ページファクトリのデフォルト実装
 */
public class DefaultPageFactoryImpl implements PageFactory {

	/**
	 * インスタンスを生成して返します。
	 *
	 * @param data
	 * @param pageable
	 * @param count
	 * @param <T>
	 * @return
	 */
	public <T> Page<T> create(List<T> data, Pageable pageable, long count) {
		return new PageImpl<>(data, pageable, count);
	}
}
