package com.isystk.sample.web.admin.controller.html.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true) // 定義されていないプロパティを無視してマッピングする
@JsonPropertyOrder({"商品ID", "名称"}) // CSVのヘッダ順
@Getter
@Setter
public class StockCsv implements Serializable {

  private static final long serialVersionUID = -1883999589975469540L;

  @JsonProperty("商品ID")
  String id;

  @JsonProperty("名称")
  String name;

}
