package com.isystk.sample.domain.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isystk.sample.domain.dao.AuditInfoHolder;
import com.isystk.sample.domain.dto.TUserCriteria;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.domain.entity.TUser;
import com.isystk.sample.domain.exception.NoDataFoundException;
import com.isystk.sample.domain.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * ユーザーヘルパー
 */
@Component
@Slf4j
public class UserHelper {

    @Autowired
    UserRepository userRepository;

    /**
     * ユーザーを全件取得します。
     *
     * @return
     */
    public List<TUser> getUserList() {
    	TUserCriteria criteria = new TUserCriteria();
    	criteria.setDeleteFlgEqual(false);
        return userRepository.findAll(criteria, Pageable.NO_LIMIT).getData();
    }

    /**
     * ログインユーザーを取得します。
     *
     * @return
     */
    public Integer getLoginUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * ログインユーザーを取得します。
     *
     * @return
     */
    public TUser getLoginUser() {
    	TUserCriteria criteria = new TUserCriteria();
    	criteria.setEmailEqual(AuditInfoHolder.getAuditUser());
        return userRepository.findOne(criteria)
                .orElseThrow(() -> new NoDataFoundException("email=" + AuditInfoHolder.getAuditUser() + "のデータが見つかりません。"));
    }
}
