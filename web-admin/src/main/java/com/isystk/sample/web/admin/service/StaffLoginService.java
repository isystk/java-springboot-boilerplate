package com.isystk.sample.web.admin.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isystk.sample.domain.dao.TStaffDao;
import com.isystk.sample.domain.dto.staff.StaffCriteria;
import com.isystk.sample.domain.repository.StaffRepository;
import com.isystk.sample.domain.service.BaseTransactionalService;
import com.isystk.sample.web.admin.dto.StaffDto;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインサービス
 */
@Component
@Slf4j
public class StaffLoginService extends BaseTransactionalService implements UserDetailsService {

    @Autowired
    TStaffDao tStaffDao;

    @Autowired
    StaffRepository staffRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = null;
        try {

        	StaffCriteria criteria = new StaffCriteria();
        	criteria.setEmail(email);

            //DBからユーザ情報を取得。
        	val staff = tStaffDao.select(criteria)
                    .orElseThrow(() -> new UsernameNotFoundException("no staff found [id=" + email + "]"));

            Set<String> authorities = new HashSet<>();
//            authorities.addAll(roleKeys);
//            authorities.addAll(permissionKeys);
            authorityList = AuthorityUtils.createAuthorityList(authorities.toArray(new String[0]));

            return new StaffDto(staff, authorityList);

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

}
