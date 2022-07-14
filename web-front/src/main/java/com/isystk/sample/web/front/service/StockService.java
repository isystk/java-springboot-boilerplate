package com.isystk.sample.web.front.service;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.StockRepositoryDto;
import com.isystk.sample.domain.repository.StockRepository;
import com.isystk.sample.solr.dto.SolrStock;
import com.isystk.sample.solr.dto.SolrStockCriteria;
import com.isystk.sample.web.front.dto.StockSearchResultDto;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.solr.repository.SolrStockRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
public class StockService extends BaseTransactionalService {

  @Autowired
  SolrStockRepository solrStockRepository;

  @Autowired
  StockRepository stockRepository;

  @Autowired
  ImageHelper imageHelper;

  /**
   * Solrの投稿インデックスを取得します。
   *
   * @param criteria
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Page<StockSearchResultDto> findSolrAll(SolrStockCriteria criteria, Pageable pageable) {
    Assert.notNull(criteria, "criteria must not be null");

    // Solrから商品データを取得する
    List<StockSearchResultDto> solrStockList = Lists.newArrayList();
    long count = solrStockRepository.count(criteria);
    if (0 < count) {
      List<SolrStock> solrStocks = solrStockRepository.query(criteria, pageable);

      for (SolrStock solrStock : solrStocks) {
        solrStockList.add(convertSolrToFrontStockDto(solrStock));
      }
    }
    return pageFactory.create(solrStockList, pageable, count);
  }

  /**
   * 商品を取得します。
   *
   * @param stockId
   * @return
   */
  public StockSearchResultDto findById(BigInteger stockId) {
    // 1件取得する
    val stock = stockRepository.findById(stockId);
    return convertDbToFrontStockDto(stock);
  }


  /**
   * @param solrStock
   * @return
   */
  private StockSearchResultDto convertSolrToFrontStockDto(SolrStock solrStock) {
    // 入力値を詰め替える
    var dto = ObjectMapperUtils.map(solrStock, StockSearchResultDto.class);
    dto.setImgUrl(
        imageHelper.getImageUrl("/stocks", solrStock.getImgpath()));
    dto.setCreatedAtYYYYMMDD(
        DateUtils.format(solrStock.getCreatedAtDate(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    dto.setCreatedAtMMDD(
        DateUtils.format(solrStock.getCreatedAtDate(), DateTimeFormatter.ofPattern("MM/dd")));
    return dto;
  }

  /**
   * @param stockRepositoryDto
   * @return
   */
  private StockSearchResultDto convertDbToFrontStockDto(StockRepositoryDto stockRepositoryDto) {
    // 入力値を詰め替える
    var dto = ObjectMapperUtils.map(stockRepositoryDto, StockSearchResultDto.class);
    dto.setImgUrl(
        imageHelper.getImageUrl("/stocks", stockRepositoryDto.getImgpath()));
    dto.setCreatedAtYYYYMMDD(
        DateUtils.format(stockRepositoryDto.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    dto.setCreatedAtMMDD(
        DateUtils.format(stockRepositoryDto.getCreatedAt(), DateTimeFormatter.ofPattern("MM/dd")));
    return dto;
  }

}
