package com.isystk.sample.domain.dto.common;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isystk.sample.domain.dao.DefaultEntityListener;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(listener = DefaultEntityListener.class) // 自動的にシステム制御項目を更新するためにリスナーを指定する
@Setter
@Getter
public abstract class DomaDtoImpl implements DomaDto, Serializable {

    /** 登録日時 */
    @JsonIgnore
    LocalDateTime registTime;

    /** 更新日時 */
    @JsonIgnore
    LocalDateTime updateTime;

    /** 削除フラグ */
    @JsonIgnore
    Boolean deleteFlg;

    /** 楽観ロック 改定番号 */
    @Version
    @Column(name = "version")
    Long version;

}
