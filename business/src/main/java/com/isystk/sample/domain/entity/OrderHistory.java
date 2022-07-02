package com.isystk.sample.domain.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;
import com.isystk.sample.domain.dto.DomaDtoImpl;

import lombok.Getter;
import lombok.Setter;

/**
 * 注文履歴
 *
 * 自動生成のため原則修正禁止!!
 *
 */
@Entity
@Table(name = "order_history")
@Getter
@Setter
public class OrderHistory extends DomaDtoImpl {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;


    /** 注文履歴ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    BigInteger id;

    /** 商品ID */
    @Column(name = "stock_id")
    BigInteger stockId;

    /** ユーザID */
    @Column(name = "user_id")
    BigInteger userId;

    /** 価格 */
    @Column(name = "price")
    Integer price;

    /** 個数 */
    @Column(name = "quantity")
    Integer quantity;

    /** 登録日時 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** 更新日時 */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    /** 削除フラグ */
    @Column(name = "delete_flg")
    Boolean deleteFlg;

    /** 楽観チェック用バージョン */
    @Version
    @Column(name = "version")
    Long version;
}