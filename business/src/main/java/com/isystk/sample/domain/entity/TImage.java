package com.isystk.sample.domain.entity;

import java.time.LocalDateTime;
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
@Table(name = "t_image")
@Getter
@Setter
public class TImage extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** 画像ID */
    @Id
    @Column(name = "IMAGE_ID")
    Integer imageId;

    /** 登録日時 */
    @Column(name = "REGIST_TIME")
    LocalDateTime registTime;

    /** 更新日時 */
    @Column(name = "UPDATE_TIME")
    LocalDateTime updateTime;

    /** 削除フラグ */
    @Column(name = "DELETE_FLG")
    Boolean deleteFlg;
}