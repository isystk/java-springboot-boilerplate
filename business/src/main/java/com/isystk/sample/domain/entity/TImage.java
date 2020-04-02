package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import com.isystk.sample.common.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "t_image")
@Getter
@Setter
public class TImage extends DomaDtoImpl {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

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
}