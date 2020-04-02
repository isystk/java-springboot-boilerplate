package com.isystk.sample.domain.dao;

import org.seasar.doma.boot.ConfigAutowireable;

import org.seasar.doma.jdbc.SelectOptions;
import java.util.Optional;
import java.util.stream.Collector;

import com.isystk.sample.domain.entity.TUser;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.SelectType;
import com.isystk.sample.domain.dto.TUserCriteria;

/**
 */
@ConfigAutowireable
@Dao
public interface TUserDao {

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(TUser entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(TUser entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(TUser entity);

	/**
	 * @param criteria
	 * @param options
	 * @return
	 */
	@Select(strategy = SelectType.COLLECT)
	<R> R selectAll(final TUserCriteria criteria, final SelectOptions options, final Collector<TUser, ?, R> collector);

	/**
	 * @param userId
	 * @return the TUser entity
	 */
	@Select
	Optional<TUser> selectById(Integer userId);

	/**
	 * @param userId
	 * @param version
	 * @return the TUser entity
	 */
	@Select(ensureResult = true)
	Optional<TUser> selectByIdAndVersion(Integer userId, Long version);

	/**
	 * @param criteria
	 * @return
	 */
	@Select
	Optional<TUser> select(TUserCriteria criteria);

}