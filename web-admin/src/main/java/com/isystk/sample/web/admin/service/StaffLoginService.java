package com.isystk.sample.web.admin.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isystk.sample.domain.entity.Staff;
import com.isystk.sample.domain.mapper.StaffMapper;
import com.isystk.sample.domain.service.BaseTransactionalService;
import com.isystk.sample.web.admin.dto.StaffDetails;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインサービス
 */
@Component
@Slf4j
public class StaffLoginService extends BaseTransactionalService implements UserDetailsService {

    @Autowired
    StaffMapper staffMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        try {

            //DBからユーザ情報を取得。
            val staff = Optional.ofNullable(staffMapper.findByEmail(email))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found."));

            return new StaffDetails(staff, getAuthorities(staff));

        } catch (Exception e) {
            if (!(e instanceof UsernameNotFoundException)) {
                // 入力間違い以外の例外はログ出力する
                log.error("failed to getLoginUser. ", e);
                throw e;
            }

            // 0件例外がスローされた場合は何もしない
            // それ以外の例外は、認証エラーの例外で包む
            throw new UsernameNotFoundException("could not select staff.", e);
        }
    }

    /**
     * 認証が通った時にこのユーザに与える権限の範囲を設定する。
     * @param account DBから取得したユーザ情報。
     * @return 権限の範囲のリスト。
     */
    private Collection<GrantedAuthority> getAuthorities(Staff staff) {
        // 認証が通った時にユーザに与える権限の範囲を設定する。
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }

}
