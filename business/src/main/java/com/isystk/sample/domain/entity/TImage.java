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

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;




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