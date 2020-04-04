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
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "t_post_tag")
@Getter
@Setter
public class TPostTag extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** 投稿ID */
    @Id
    @Column(name = "POST_ID")
    Integer postId;

    /** 投稿タグID */
    @Id
    @Column(name = "POST_TAG_ID")
    Integer postTagId;
}