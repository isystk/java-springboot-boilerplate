package com.isystk.sample.batch.jobs.importMst;

import javax.validation.constraints.NotEmpty;

import com.isystk.sample.batch.item.ItemPosition;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImportMstStockDto implements ItemPosition {

  /** 商品名 */
  @NotEmpty
  String name;

  /** 説明文 */
  @NotEmpty
  String detail;

  /** 価格 */
  @NotEmpty
  String price;

  /** 画像ファイル名 */
  @NotEmpty
  String imgpath;

  /** 在庫数 */
  @NotEmpty
  String quantity;

  // 取り込み元ファイル
  String sourceName;

  int position;
}
