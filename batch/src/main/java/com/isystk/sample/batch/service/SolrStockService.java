package com.isystk.sample.batch.service;

import com.google.common.collect.Lists;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.repository.StockRepository;
import com.isystk.sample.solr.dto.SolrStock;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.solr.repository.SolrStockRepository;

@Service
public class SolrStockService extends BaseTransactionalService {

  @Autowired
  SolrStockRepository solrStockRepository;

  @Autowired
  StockRepository stockRepository;

  /**
   * Solrの商品インデックスを更新します。
   *
   * @return
   */
  public void refresh() {

    // 有効な商品を全件取得する
    var criteria = new StockCriteria();
    criteria.setDeleteFlgFalse(true);
    val stockList = stockRepository.findAll(criteria);
    if (stockList.size() == 0) {
      // 商品データが0件の場合は何もしない
      return;
    }

    List<SolrStock> solrStockList = Lists.newArrayList();
    stockList
        .stream()
        .forEach(stock -> {
          SolrStock solrStock = ObjectMapperUtils.map(stock, SolrStock.class);
          solrStock.setStockId(stock.getId().intValue());
          solrStockList.add(solrStock);
        });

    // Solrをすべて削除
    solrStockRepository.deleteAll();

    // Solrに保存
    solrStockRepository.saveAll(solrStockList);
  }

}
