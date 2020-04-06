package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.MPostTagDao;
import com.isystk.sample.domain.dto.MPostTagCriteria;
import com.isystk.sample.domain.entity.MPostTag;
import com.isystk.sample.domain.repository.dto.MPostTagRepositoryDto;

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
	public Page<MPostTagRepositoryDto> findAll(MPostTagCriteria criteria, Pageable pageable) {
		var options = createSelectOptions(pageable);
		// ページングを指定する
		return pageFactory.create(convertDto(
				mPostTagDao.findAll(criteria,
				options.count(),
				toList()
			)), pageable, options.getCount());
	}

	/**
	 * RepositoryDto に変換します。
	 * @param mPostTagList
	 * @return
	 */
	private List<MPostTagRepositoryDto> convertDto(List<MPostTag> mPostTagList) {

		return ObjectMapperUtils.mapAll(mPostTagList, MPostTagRepositoryDto.class);
	}

}
