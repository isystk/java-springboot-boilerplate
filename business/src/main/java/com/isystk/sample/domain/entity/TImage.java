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
@Table(name = "t_image")
public class TImage extends DomaDtoImpl {

    /** ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;

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
     * Returns the imageId.
     *
     * @return the imageId
     */
    public Integer getImageId() {
        return imageId;
    }

    /**
     * Sets the imageId.
     *
     * @param imageId the imageId
     */
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
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