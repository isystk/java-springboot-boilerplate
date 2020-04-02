package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

import com.isystk.sample.common.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "t_post")
@Getter
@Setter
public class TPost extends DomaDtoImpl {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

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
	LocalDateTime registTime;

	/**  */
	@Column(name = "UPDATE_TIME")
	LocalDateTime updateTime;

	/**  */
	@Column(name = "DELETE_FLG")
	Boolean deleteFlg;

	/**  */
	@Version
	@Column(name = "VERSION")
	Long version;
}