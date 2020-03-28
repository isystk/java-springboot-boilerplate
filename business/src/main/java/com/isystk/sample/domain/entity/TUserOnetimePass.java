package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

/**
 * 
 */
@Entity
@Table(name = "t_user_onetime_pass")
public class TUserOnetimePass extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** ID */
    @Id
    @Column(name = "USER_ID")
    Integer userId;

    /**  */
    @Column(name = "ONETIME_KEY")
    String onetimeKey;

    /**  */
    @Column(name = "ONETIME_VALID_TIME")
    LocalDateTime onetimeValidTime;

    /**
     * Returns the userId.
     *
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the userId.
     *
     * @param userId the userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    /**
     * Returns the onetimeKey.
     *
     * @return the onetimeKey
     */
    public String getOnetimeKey() {
        return onetimeKey;
    }

    /**
     * Sets the onetimeKey.
     *
     * @param onetimeKey the onetimeKey
     */
    public void setOnetimeKey(String onetimeKey) {
        this.onetimeKey = onetimeKey;
    }
    /**
     * Returns the onetimeValidTime.
     *
     * @return the onetimeValidTime
     */
    public LocalDateTime getOnetimeValidTime() {
        return onetimeValidTime;
    }

    /**
     * Sets the onetimeValidTime.
     *
     * @param onetimeValidTime the onetimeValidTime
     */
    public void setOnetimeValidTime(LocalDateTime onetimeValidTime) {
        this.onetimeValidTime = onetimeValidTime;
    }
}