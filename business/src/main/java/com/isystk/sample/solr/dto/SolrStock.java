package com.isystk.sample.solr.dto;

import com.isystk.sample.common.dto.Dto;
import java.util.Date;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;

import java.time.LocalDateTime;

@Data
public class SolrStock implements Dto {

  @Field("id")
  private String id;

  @Field("stock_id")
  private Integer stockId;

  @Field("name")
  private String name;

  @Field("detail")
  private String detail;

  @Field("price")
  private Integer price;

  @Field("imgpath")
  private String imgpath;

  @Field("quantity")
  private Integer quantity;

  @Field("created_at")
  private Date createdAtDate;

}