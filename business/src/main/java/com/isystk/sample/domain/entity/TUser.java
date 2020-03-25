package com.isystk.sample.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

/**
 * 
 */
@Entity
@Table(name = "t_user")
public class TUser extends DomaDtoImpl {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    Integer userId;

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
    @Column(name = "ZIP")
    String zip;

    /**  */
    @Column(name = "PREFECTURE_ID")
    Integer prefectureId;

    /**  */
    @Column(name = "AREA")
    String area;

    /**  */
    @Column(name = "ADDRESS")
    String address;

    /**  */
    @Column(name = "BUILDING")
    String building;

    /**  */
    @Column(name = "TEL")
    String tel;

    /**  */
    @Column(name = "SEX")
    Integer sex;

    /**  */
    @Column(name = "BIRTHDAY")
    LocalDate birthday;

    /**  */
    @Column(name = "LAST_LOGIN_TIME")
    LocalDateTime lastLoginTime;

    /**  */
    @Column(name = "STATUS")
    Integer status;

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
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
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
     * Returns the zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the zip.
     *
     * @param zip the zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Returns the prefectureId.
     *
     * @return the prefectureId
     */
    public Integer getPrefectureId() {
        return prefectureId;
    }

    /**
     * Sets the prefectureId.
     *
     * @param prefectureId the prefectureId
     */
    public void setPrefectureId(Integer prefectureId) {
        this.prefectureId = prefectureId;
    }

    /**
     * Returns the area.
     *
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * Sets the area.
     *
     * @param area the area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Returns the address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the building.
     *
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Sets the building.
     *
     * @param building the building
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * Returns the tel.
     *
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the tel.
     *
     * @param tel the tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Returns the sex.
     *
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Sets the sex.
     *
     * @param sex the sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * Returns the birthday.
     *
     * @return the birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Sets the birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Returns the lastLoginTime.
     *
     * @return the lastLoginTime
     */
    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Sets the lastLoginTime.
     *
     * @param lastLoginTime the lastLoginTime
     */
    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Returns the status.
     *
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * Returns the registTime.
     *
     * @return the registTime
     */
    public LocalDateTime getRegistTime() {
        return registTime;
    }

    /**
     * Sets the registTime.
     *
     * @param registTime the registTime
     */
    public void setRegistTime(LocalDateTime registTime) {
        this.registTime = registTime;
    }

    /**
     * Returns the updateTime.
     *
     * @return the updateTime
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**
     * Sets the updateTime.
     *
     * @param updateTime the updateTime
     */
    public void setUpdateTime(LocalDateTime updateTime) {
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