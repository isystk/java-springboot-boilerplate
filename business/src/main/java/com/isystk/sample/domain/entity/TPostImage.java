package com.isystk.sample.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

/**
 * 
 */
@Entity
@Table(name = "t_post_image")
public class TPostImage extends DomaDtoImpl {

    /** ID */
    @Id
    @Column(name = "POST_ID")
    Integer postId;

    /** ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;

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
}