package com.isystk.sample.domain.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 
 */
@Entity(listener = TStaffListener.class)
@Table(name = "t_staff")
public class TStaff {

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
    byte[] password;

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
    Timestamp lastLoginTime;

    /**  */
    @Column(name = "REGIST_TIME")
    Timestamp registTime;

    /**  */
    @Column(name = "UPDATE_TIME")
    Timestamp updateTime;

    /**  */
    @Column(name = "DELETE_FLG")
    Boolean deleteFlg;

    /**  */
    @Version
    @Column(name = "VERSION")
    Long version;

    /** 
     * Returns the staffId.
     * 
     * @return the staffId
     */
    public Integer getStaffId() {
        return staffId;
    }

    /** 
     * Sets the staffId.
     * 
     * @param staffId the staffId
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /** 
     * Returns the email.
     * 
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Sets the email.
     * 
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public byte[] getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }

    /** 
     * Returns the familyName.
     * 
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /** 
     * Sets the familyName.
     * 
     * @param familyName the familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /** 
     * Returns the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /** 
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /** 
     * Returns the familyNameKana.
     * 
     * @return the familyNameKana
     */
    public String getFamilyNameKana() {
        return familyNameKana;
    }

    /** 
     * Sets the familyNameKana.
     * 
     * @param familyNameKana the familyNameKana
     */
    public void setFamilyNameKana(String familyNameKana) {
        this.familyNameKana = familyNameKana;
    }

    /** 
     * Returns the nameKana.
     * 
     * @return the nameKana
     */
    public String getNameKana() {
        return nameKana;
    }

    /** 
     * Sets the nameKana.
     * 
     * @param nameKana the nameKana
     */
    public void setNameKana(String nameKana) {
        this.nameKana = nameKana;
    }

    /** 
     * Returns the lastLoginTime.
     * 
     * @return the lastLoginTime
     */
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    /** 
     * Sets the lastLoginTime.
     * 
     * @param lastLoginTime the lastLoginTime
     */
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /** 
     * Returns the registTime.
     * 
     * @return the registTime
     */
    public Timestamp getRegistTime() {
        return registTime;
    }

    /** 
     * Sets the registTime.
     * 
     * @param registTime the registTime
     */
    public void setRegistTime(Timestamp registTime) {
        this.registTime = registTime;
    }

    /** 
     * Returns the updateTime.
     * 
     * @return the updateTime
     */
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /** 
     * Sets the updateTime.
     * 
     * @param updateTime the updateTime
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /** 
     * Returns the deleteFlg.
     * 
     * @return the deleteFlg
     */
    public Boolean getDeleteFlg() {
        return deleteFlg;
    }

    /** 
     * Sets the deleteFlg.
     * 
     * @param deleteFlg the deleteFlg
     */
    public void setDeleteFlg(Boolean deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /** 
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /** 
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}