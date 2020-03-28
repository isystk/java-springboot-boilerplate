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

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_TAG_ID")
    Integer postTagId;

    /**  */
    @Column(name = "NAME")
    String name;




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
}