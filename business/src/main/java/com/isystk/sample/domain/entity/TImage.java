package com.isystk.sample.domain.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = TImageListener.class)
@Table(name = "t_image")
public class TImage {

    /** ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;

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