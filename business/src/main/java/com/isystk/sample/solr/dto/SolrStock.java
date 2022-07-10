package com.isystk.sample.solr.dto;

import com.isystk.sample.common.dto.Dto;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.time.LocalDateTime;

@SolrDocument(collection = "stock")
public class SolrStock implements Dto {

  @Id
  @Indexed(name = "id")
  private String id;

  @Indexed(name = "stock_id")
  private Integer stockId;

  @Indexed(name = "name")
  private String name;

  @Indexed(name = "detail")
  private String detail;

  @Indexed(name = "price")
  private Integer price;

  @Indexed(name = "imgpath")
  private String imgpath;

  @Indexed(name = "quantity")
  private Integer quantity;

  @Indexed(name = "created_at")
  private LocalDateTime createdAt;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getStockId() {
    return stockId;
  }

  public void setStockId(Integer stockId) {
    this.stockId = stockId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getImgpath() {
    return imgpath;
  }

  public void setImgpath(String imgpath) {
    this.imgpath = imgpath;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}