package com.isystk.sample.domain.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.domain.dao.TUserOnetimeValidDao;
import com.isystk.sample.domain.dto.TUserOnetimeValidCriteria;
import com.isystk.sample.domain.entity.TUserOnetimeValid;

/**
 * ユーザーワンタイム認証リポジトリ
 */
@Repository
public class TUserOnetimeValidRepository extends BaseRepository {

	@Autowired
	TUserOnetimeValidDao tUserOnetimeValidDao;

	/**
	 * ワンタイムキーを元にーザーワンタイム認証を取得します。
	 *
	 * @param criteria
	 * @return
	 */
	public Optional<TUserOnetimeValid> findOneByOnetimeKey(String onetimeKey) {
    	TUserOnetimeValidCriteria criteria = new TUserOnetimeValidCriteria();
    	criteria.setOnetimeKeyEqual(onetimeKey);
		return tUserOnetimeValidDao.select(criteria);
	}

	/**
	 * ユーザーワンタイム認証を追加します。
	 *
	 * @param inputUserOnetimeValid
	 * @return
	 */
	public TUserOnetimeValid create(final TUserOnetimeValid inputUserOnetimeValid) {

		// 1件登録
		tUserOnetimeValidDao.insert(inputUserOnetimeValid);

		return inputUserOnetimeValid;
	}

}
