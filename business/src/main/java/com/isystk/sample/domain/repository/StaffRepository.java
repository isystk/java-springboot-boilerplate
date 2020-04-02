package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.domain.dao.TStaffDao;
import com.isystk.sample.domain.dto.TStaffCriteria;
import com.isystk.sample.domain.entity.TStaff;

import lombok.val;

/**
 * 担当者リポジトリ
 */
@Repository
public class StaffRepository extends BaseRepository {

	@Autowired
	TStaffDao tStaffDao;

	/**
	 * 担当者を複数取得します。
	 *
	 * @param criteria
	 * @param pageable
	 * @return
	 */
	public Page<TStaff> findAll(TStaffCriteria criteria, Pageable pageable) {
		// ページングを指定する
		val options = createSelectOptions(pageable).count();
		val data = tStaffDao.selectAll(criteria, options, toList());
		return pageFactory.create(data, pageable, options.getCount());
	}

	/**
	 * 担当者を取得します。
	 *
	 * @param criteria
	 * @return
	 */
	public Optional<TStaff> findOne(TStaffCriteria criteria) {
		return tStaffDao.select(criteria);
	}

	/**
	 * 担当者を取得します。
	 *
	 * @return
	 */
	public TStaff findById(final Integer id) {
		return tStaffDao.selectById(id)
				.orElseThrow(() -> new NoDataFoundException("staff_id=" + id + " のデータが見つかりません。"));
	}

	/**
	 * 担当者を追加します。
	 *
	 * @param inputStaff
	 * @return
	 */
	public TStaff create(final TStaff inputStaff) {
		// 1件登録
		val time = DateUtils.getNow();

		inputStaff.setRegistTime(time); // 作成日
		inputStaff.setUpdateTime(time); // 更新日
		inputStaff.setDeleteFlg(false); // 削除フラグ
		inputStaff.setVersion(0L); // 楽観ロック改定番号
		tStaffDao.insert(inputStaff);

		return inputStaff;
	}

	/**
	 * 担当者を更新します。
	 *
	 * @param inputStaff
	 * @return
	 */
	public TStaff update(final TStaff inputStaff) {
		// 1件更新
		val time = DateUtils.getNow();
		inputStaff.setUpdateTime(time); // 更新日
		int updated = tStaffDao.update(inputStaff);

		if (updated < 1) {
			throw new NoDataFoundException("staff_id=" + inputStaff.getStaffId() + " のデータが見つかりません。");
		}

		return inputStaff;
	}

	/**
	 * 担当者を論理削除します。
	 *
	 * @return
	 */
	public TStaff delete(final Integer id) {
		val staff = tStaffDao.selectById(id)
				.orElseThrow(() -> new NoDataFoundException("staff_id=" + id + " のデータが見つかりません。"));

		int updated = tStaffDao.delete(staff);

		if (updated < 1) {
			throw new NoDataFoundException("staff_id=" + id + " は更新できませんでした。");
		}

		return staff;
	}
}
