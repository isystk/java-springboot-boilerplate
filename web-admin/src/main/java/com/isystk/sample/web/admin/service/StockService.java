package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.entity.Stocks;
import com.isystk.sample.domain.repository.StockRepository;
import com.isystk.sample.domain.repository.dto.StockRepositoryDto;
import java.math.BigInteger;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class StockService extends BaseTransactionalService {

  @Autowired
  StockRepository stockRepository;

  public StockRepositoryDto findById(BigInteger stockId) {
    // 1件取得する
    val stocks = stockRepository.findById(stockId);

    return stocks;
  }


  /**
   * 商品を追加します。
   *
   * @param stockDto 
   * @return
   */
  public Stocks create(final StockRepositoryDto stockDto) {
    Assert.notNull(stockDto, "input must not be null");
    return stockRepository.create(stockDto);
  }

  /**
   * 商品を更新します。
   *
   * @param stockDto 
   * @return
   */
  public Stocks update(final StockRepositoryDto stockDto) {
    Assert.notNull(stockDto, "input must not be null");
    return stockRepository.update(stockDto);
  }

  /**
   * 商品を論理削除します。
   *
   * @return
   */
  public Stocks delete(final BigInteger id) {
    Assert.notNull(id, "id must not be null");
    return stockRepository.delete(id);
  }
}
