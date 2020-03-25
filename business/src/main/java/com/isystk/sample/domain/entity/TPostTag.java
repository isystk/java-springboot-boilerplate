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
@Table(name = "t_post_tag")
public class TPostTag extends DomaDtoImpl {

    /** ID */
    @Id
    @Column(name = "POST_ID")
    Integer postId;

    /** ID */
    @Id
    @Column(name = "POST_TAG_ID")
    Integer postTagId;

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
}