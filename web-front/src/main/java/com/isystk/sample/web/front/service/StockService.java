package com.isystk.sample.web.front.service;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.solr.dto.SolrStock;
import com.isystk.sample.solr.dto.SolrStockCriteria;
import com.isystk.sample.web.front.dto.StockSearchResultDto;
import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.castor.core.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.solr.repository.SolrStockRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService extends BaseTransactionalService {

  @Autowired
  SolrStockRepository solrStockRepository;

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

    // TODO ここでページングを設定
    Iterable<SolrStock> solrStocks = solrStockRepository.findAll();

    List<StockSearchResultDto> solrStockList = Lists.newArrayList();
    int count = 0;
    for (SolrStock solrStock : solrStocks) {
      int from = (pageable.getPage()-1) * pageable.getPerpage();
      int to = pageable.getPage() * pageable.getPerpage();
      if (from <= count && count< to) {
        solrStockList.add(convertSolrToFrontStockDto(solrStock));
      }
      count++;
    }

    return pageFactory.create(solrStockList, pageable, count);
  }

  /**
   * Solrの投稿インデックスを取得します。
   *
   * @param stockId
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public Optional<StockSearchResultDto> findSolrById(BigInteger stockId) {
    Assert.notNull(stockId, "criteria must not be null");

    SolrStock solrStock = solrStockRepository.findByStockId(stockId);

    return Optional.of(convertSolrToFrontStockDto(solrStock));
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
        DateUtils.format(solrStock.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
    dto.setCreatedAtMMDD(
        DateUtils.format(solrStock.getCreatedAt(), DateTimeFormatter.ofPattern("MM/dd")));
    return dto;
  }

}
