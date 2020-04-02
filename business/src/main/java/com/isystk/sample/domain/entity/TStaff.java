package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

import com.isystk.sample.common.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "t_staff")
@Getter
@Setter
public class TStaff extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STAFF_ID")
    Integer staffId;

    /**  */
    @Column(name = "EMAIL")
    String email;

    /**  */
    @Column(name = "PASSWORD")
    String password;

    /**  */
    @Column(name = "FAMILY_NAME")
    String familyName;

    /**  */
    @Column(name = "NAME")
    String name;

    /**  */
    @Column(name = "FAMILY_NAME_KANA")
    String familyNameKana;

    /**  */
    @Column(name = "NAME_KANA")
    String nameKana;

    /**  */
    @Column(name = "LAST_LOGIN_TIME")
    LocalDateTime lastLoginTime;

    /**  */
    @Column(name = "REGIST_TIME")
    LocalDateTime registTime;

    /**  */
    @Column(name = "UPDATE_TIME")
    LocalDateTime updateTime;

    /**  */
    @Column(name = "DELETE_FLG")
    Boolean deleteFlg;

    /**  */
    @Version
    @Column(name = "VERSION")
    Long version;
}