package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.TUserDao;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.domain.repository.dto.TUserRepositoryDto;

import lombok.val;

/**
 * ユーザーリポジトリ
 */
@Repository
public class TUserRepository extends BaseRepository {

	@Autowired
	TUserDao tUserDao;

	/**
	 * 投稿を複数取得します。
	 *
	 * @param criteria
	 * @param pageable
	 * @return
	 */
	public Page<TUserRepositoryDto> findAll(TUserCriteria criteria, Pageable pageable) {
		var options = createSelectOptions(pageable);
		// ページングを指定する
		return pageFactory.create(convertDto(
				tUserDao.findAll(criteria,
				options.count(),
				toList()
			)), pageable, options.getCount());
	}

	/**
	 * RepositoryDto に変換します。
	 * @param tUserList
	 * @return
	 */
	private List<TUserRepositoryDto> convertDto(List<TUser> tUserList) {

		return ObjectMapperUtils.mapAll(tUserList, TUserRepositoryDto.class);
	}

	/**
	 * ユーザーを追加します。
	 *
	 * @param inputUser
	 * @return
	 */
	public TUser create(final TUser inputUser) {

		// 1件登録
		val time = DateUtils.getNow();

		inputUser.setRegistTime(time); // 作成日
		inputUser.setUpdateTime(time); // 更新日
		inputUser.setDeleteFlg(false); // 削除フラグ
		inputUser.setVersion(0L); // 楽観ロック改定番号
		tUserDao.insert(inputUser);

		return inputUser;
	}

	/**
	 * ユーザーを更新します。
	 *
	 * @param inputUser
	 * @return
	 */
	public TUser update(final TUser inputUser) {
		// 1件更新
		val time = DateUtils.getNow();
		inputUser.setUpdateTime(time); // 更新日
		int updated = tUserDao.update(inputUser);

		if (updated < 1) {
			throw new NoDataFoundException("user_id=" + inputUser.getUserId() + " のデータが見つかりません。");
		}

		return inputUser;
	}

	/**
	 * ユーザーを論理削除します。
	 *
	 * @return
	 */
	public TUser delete(final Integer id) {
		val user = tUserDao.selectById(id)
				.orElseThrow(() -> new NoDataFoundException("user_id=" + id + " のデータが見つかりません。"));

		int updated = tUserDao.delete(user);

		if (updated < 1) {
			throw new NoDataFoundException("user_id=" + id + " は更新できませんでした。");
		}

		return user;
	}
}
