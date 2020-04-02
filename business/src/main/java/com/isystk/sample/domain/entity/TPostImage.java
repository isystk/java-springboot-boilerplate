package com.isystk.sample.domain.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import com.isystk.sample.domain.dto.common.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "t_post_image")
@Getter
@Setter
public class TPostImage extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** ID */
    @Id
    @Column(name = "POST_ID")
    Integer postId;

    /** ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;
}