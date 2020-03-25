package com.isystk.sample.domain.dto.common;

import java.time.LocalDateTime;

// TODO: コメントを書く
public interface DomaDto extends Dto {

	LocalDateTime getRegistTime();

    void setRegistTime(LocalDateTime registTime);

    LocalDateTime getUpdateTime();

    void setUpdateTime(LocalDateTime updateTime);

    Boolean getDeleteFlg();

    void setDeleteFlg(Boolean deleteFlg);

    Long getVersion();

    void setVersion(Long version);
}
