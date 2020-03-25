package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

/**
 * 
 */
@Entity
@Table(name = "m_post_tag")
public class MPostTag extends DomaDtoImpl {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_TAG_ID")
    Integer postTagId;

    /**  */
    @Column(name = "NAME")
    String name;

    /**  */
    @Column(name = "REGIST_TIME")
    LocalDateTime registTime;

    /**  */
    @Column(name = "UPDATE_TIME")
    LocalDateTime updateTime;

    /**  */
    @Column(name = "DELETE_FLG")
    Boolean deleteFlg;

    /**
     * Returns the postTagId.
     *
     * @return the postTagId
     */
    public Integer getPostTagId() {
        return postTagId;
    }

    /**
     * Sets the postTagId.
     *
     * @param postTagId the postTagId
     */
    public void setPostTagId(Integer postTagId) {
        this.postTagId = postTagId;
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
}