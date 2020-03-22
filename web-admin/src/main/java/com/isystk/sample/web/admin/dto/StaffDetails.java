package com.isystk.sample.web.admin.dto;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.isystk.sample.domain.entity.Staff;
import com.isystk.sample.web.base.filter.UserIdAware;

public class StaffDetails extends User implements UserIdAware {

    // 管理者情報。
    private final Staff staff;

    public StaffDetails(Staff staff,
            Collection<GrantedAuthority> authorities) {

        super(staff.getEmail(), staff.getPassword(),
                true, true, true, true, authorities);

        this.staff = staff;
    }

    public Staff Staff() {
        return staff;
    }

	@Override
	public String getUserId() {
		return String.valueOf(this.staff.getId());
	}

}