package com.isystk.sample.domain.dao;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

import com.isystk.sample.common.util.ReflectionUtils;
import com.isystk.sample.domain.dto.common.DomaDto;
import com.isystk.sample.domain.dto.common.Dto;
import com.isystk.sample.domain.exception.DoubleSubmitErrorException;

import lombok.NoArgsConstructor;
import lombok.val;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor // コンストラクタが必須のため
@Slf4j
public class DefaultEntityListener<ENTITY> implements EntityListener<ENTITY> {

	/**
	 * 新規登録
	 */
    @Override
    public void preInsert(ENTITY entity, PreInsertContext<ENTITY> context) {
        // 二重送信防止チェック
        val expected = DoubleSubmitCheckTokenHolder.getExpectedToken();
        val actual = DoubleSubmitCheckTokenHolder.getActualToken();

        if (expected != null && actual != null && !Objects.equals(expected, actual)) {
            throw new DoubleSubmitErrorException();
        }

        if (entity instanceof DomaDto) {
            val domaDto = (DomaDto) entity;
            val registTime = AuditInfoHolder.getAuditDateTime();

            domaDto.setRegistTime(registTime); // 作成日
            domaDto.setUpdateTime(registTime); // 更新日
            domaDto.setDeleteFlg(false); // 削除フラグ
            domaDto.setVersion(0L); // 楽観ロック改定番号
        }
    }

    /**
     * 更新・論理削除
     */
    @Override
    public void preUpdate(ENTITY entity, PreUpdateContext<ENTITY> context) {

        if (entity instanceof DomaDto) {
            val domaDto = (DomaDto) entity;
            val time = AuditInfoHolder.getAuditDateTime();

            val methodName = context.getMethod().getName();
            if (StringUtils.startsWith("delete", methodName)) {
                domaDto.setUpdateTime(time); // 削除日
                domaDto.setDeleteFlg(true); // 削除フラグ
            } else {
                domaDto.setUpdateTime(time); // 更新日
            }
        }
    }

    /**
     * 物理削除
     */
    @Override
    public void preDelete(ENTITY entity, PreDeleteContext<ENTITY> context) {

        if (entity instanceof DomaDto) {
            val domaDto = (DomaDto) entity;
            val deletedAt = AuditInfoHolder.getAuditDateTime();
            val deletedBy = AuditInfoHolder.getAuditUser();
            val name = domaDto.getClass().getName();
            val ids = getIds(domaDto);

            // 物理削除した場合はログ出力する
            log.info("データを物理削除しました。entity={}, id={}, deletedBy={}, deletedAt={}", name, ids, deletedBy, deletedAt);
        }
    }

    /**
     * Idアノテーションが付与されたフィールドの値のリストを返します。
     *
     * @param dto
     * @return
     */
    protected List<Object> getIds(Dto dto) {
        return ReflectionUtils.findWithAnnotation(dto.getClass(), Id.class)
                .map(f -> ReflectionUtils.getFieldValue(f, dto)).collect(toList());
    }
}
