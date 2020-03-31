package com.isystk.sample.domain.dto.common;

import java.io.Serializable;
import org.seasar.doma.Entity;

import com.isystk.sample.domain.dao.DefaultEntityListener;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity(listener = DefaultEntityListener.class) // 自動的にシステム制御項目を更新するためにリスナーを指定する
@Setter
@Getter
public abstract class DomaDtoImpl implements DomaDto, Serializable {

}
