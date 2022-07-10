package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.dto.UserRepositoryDto;
import com.isystk.sample.domain.repository.UserRepository;
import com.isystk.sample.web.admin.dto.UserSearchConditionDto;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseTransactionalService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserDao userDao;

  /**
   * 顧客を複数取得します。
   *
   * @param dto
   * @return
   */
  public List<UserRepositoryDto> findAll(UserSearchConditionDto dto) {
    return userRepository.findAll(dtoToCriteria(dto));
  }

  /**
   * 顧客を複数取得します。(ページングあり)
   *
   * @param dto
   * @param pageable
   * @return
   */
  public Page<UserRepositoryDto> findPage(UserSearchConditionDto dto, Pageable pageable) {
    return userRepository.findPage(dtoToCriteria(dto), pageable);
  }


  /**
   * 検索条件を詰める
   *
   * @return
   */
  private UserCriteria dtoToCriteria(
      UserSearchConditionDto dto) {
    // 入力値を詰め替える
    UserCriteria criteria = new UserCriteria();
    criteria.setNameLike(dto.getName());
    criteria.setEmailLike(dto.getEmail());
    if (dto.getCreatedAtFrom() != null) {
      criteria.setCreatedAtGe(dto.getCreatedAtFrom().atStartOfDay());
    }
    if (dto.getCreatedAtTo() != null) {
      criteria.setCreatedAtLe(dto.getCreatedAtTo().atTime(LocalTime.MAX));
    }
    criteria.setDeleteFlgFalse(true);
    criteria.setOrderBy("order by updated_at desc");
    return criteria;
  }

  /**
   * 顧客を取得します。
   *
   * @param userId
   * @return
   */
  public UserRepositoryDto findById(BigInteger userId) {
    return userRepository.findById(userId);
  }

}
