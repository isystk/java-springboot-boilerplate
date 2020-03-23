package com.isystk.sample.domain.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = MPostTagListener.class)
@Table(name = "m_post_tag")
public class MPostTag {

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
    Timestamp registTime;

    /**  */
    @Column(name = "UPDATE_TIME")
    Timestamp updateTime;

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
}