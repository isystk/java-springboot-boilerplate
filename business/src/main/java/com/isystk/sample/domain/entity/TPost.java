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
@Entity(listener = TPostListener.class)
@Table(name = "t_post")
public class TPost {

    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    Integer postId;

    /** ID */
    @Column(name = "USER_ID")
    Integer userId;

    /**  */
    @Column(name = "TITLE")
    String title;

    /**  */
    @Column(name = "TEXT")
    String text;

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
     * Returns the postId.
     *
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * Sets the postId.
     *
     * @param postId the postId
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

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
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
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