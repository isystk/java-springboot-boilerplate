package com.isystk.sample.web.admin.dto;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.isystk.sample.domain.entity.TStaff;
import com.isystk.sample.web.base.filter.UserIdAware;

public class StaffDto extends User implements UserIdAware {

    // 管理者情報。
    private final TStaff staff;

    public StaffDto(TStaff staff,
            List<GrantedAuthority> authorities) {

        super(staff.getEmail(), new String(staff.getPassword()),
                true, true, true, true, authorities);

        this.staff = staff;
    }

    public TStaff Staff() {
        return staff;
    }

	@Override
	public String getUserId() {
		return String.valueOf(this.staff.getStaffId());
	}

}