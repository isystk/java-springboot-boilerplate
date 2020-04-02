package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.entity.MPostTag;

import lombok.val;

/**
 * 投稿タグマスタリポジトリ
 */
@Repository
public class MPostTagRepository extends BaseRepository {

	@Autowired
	MPostTagDao mPostTagDao;

	/**
	 * 投稿タグを複数取得します。
	 *
	 * @param criteria
	 * @param pageable
	 * @return
	 */
	public Page<MPostTag> findAll(MPostTagCriteria criteria, Pageable pageable) {
		// ページングを指定する
		val options = createSelectOptions(pageable).count();
		val data = mPostTagDao.selectAll(criteria, options, toList());
		return pageFactory.create(data, pageable, options.getCount());
	}

}
