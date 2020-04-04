package com.isystk.sample.web.admin.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.isystk.sample.domain.dao.TStaffDao;
import com.isystk.sample.domain.dto.TStaffCriteria;
import com.isystk.sample.domain.entity.TStaff;
import com.isystk.sample.web.base.security.BaseRealm;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

/**
 * ログインサービス
 */
@Component
@Slf4j
public class StaffDaoRealm extends BaseRealm {

	@Autowired
	TStaffDao tStaffDao;

	@Override
	protected UserDetails getLoginUser(String email) {
		TStaff staff = null;
		List<GrantedAuthority> authorityList = null;

		try {
			// login_idをメールアドレスと見立てる
			val criteria = new TStaffCriteria();
			criteria.setEmailEq(email);

			// 担当者を取得して、セッションに保存する
			staff = tStaffDao.findOne(criteria)
					.orElseThrow(() -> new UsernameNotFoundException("no staff found [id=" + email + "]"));
//
//            // 担当者権限を取得する
//            List<StaffRole> staffRoles = staffRoleDao.selectByStaffId(staff.getId(), toList());
//
//            // 役割キーにプレフィックスをつけてまとめる
//            Set<String> roleKeys = staffRoles.stream().map(StaffRole::getRoleKey).collect(toSet());
//
//            // 権限キーをまとめる
//            Set<String> permissionKeys = staffRoles.stream().map(StaffRole::getPermissionKey).collect(toSet());

			// 役割と権限を両方ともGrantedAuthorityとして渡す
			Set<String> authorities = new HashSet<>();
//            authorities.addAll(roleKeys);
//            authorities.addAll(permissionKeys);
			authorityList = AuthorityUtils.createAuthorityList(authorities.toArray(new String[0]));

			return new LoginStaff(staff, authorityList);

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
