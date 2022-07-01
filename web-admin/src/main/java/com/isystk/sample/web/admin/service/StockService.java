package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.helper.ImageHelper;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.entity.Stock;
import com.isystk.sample.domain.repository.StockRepository;
import com.isystk.sample.domain.dto.StockRepositoryDto;
import com.isystk.sample.web.admin.dto.StockSearchConditionDto;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class StockService extends BaseTransactionalService {

  @Autowired
  ImageHelper imageHelper;

  @Autowired
  StockRepository stockRepository;

  /**
   * 商品を複数取得します。
   *
   * @param dto
   * @return
   */
  public List<StockRepositoryDto> findAll(StockSearchConditionDto dto) {
    return stockRepository.findAll(dtoToCriteria(dto));
  }

  /**
   * 商品を複数取得します。(ページングあり)
   *
   * @param dto
   * @param pageable
   * @return
   */
  public Page<StockRepositoryDto> findPage(StockSearchConditionDto dto, Pageable pageable) {
    return stockRepository.findPage(dtoToCriteria(dto), pageable);
  }

  /**
   * 検索条件を詰める
   *
   * @return
   */
  private StockCriteria dtoToCriteria(
      StockSearchConditionDto dto) {
    // 入力値を詰め替える
    StockCriteria criteria = new StockCriteria();
    criteria.setIdEq(dto.getStockId());
    criteria.setNameLike(dto.getName());
    if (dto.getCreatedAtFrom() != null) {
      criteria.setCreatedAtGe(dto.getCreatedAtFrom().atStartOfDay());
    }
    if (dto.getCreatedAtTo() != null) {
      criteria.setCreatedAtLe(dto.getCreatedAtTo().atTime(LocalTime.MAX));
    }
    criteria.setDeleteFlgFalse(true);
    criteria.setOrderBy("order by updated_at desc");
    return criteria;
  }

  /**
   * 商品を取得します。
   *
   * @param stockId
   * @return
   */
  public StockRepositoryDto findById(BigInteger stockId) {
    // 1件取得する
    val stock = stockRepository.findById(stockId);

    String imageData = imageHelper.getImageData("/stocks", stock.getImgpath());
    stock.setStockImageData(imageData);
    stock.setStockImageName(stock.getImgpath());

    return stock;
  }


  /**
   * 商品を追加します。
   *
   * @param stockDto 
   * @return
   */
  public Stock create(final StockRepositoryDto stockDto) {
    Assert.notNull(stockDto, "input must not be null");
    return stockRepository.create(stockDto);
  }

  /**
   * 商品を更新します。
   *
   * @param stockDto 
   * @return
   */
  public Stock update(final StockRepositoryDto stockDto) {
    Assert.notNull(stockDto, "input must not be null");
    return stockRepository.update(stockDto);
  }

  /**
   * 商品を論理削除します。
   *
   * @return
   */
  public Stock delete(final BigInteger id) {
    Assert.notNull(id, "id must not be null");
    return stockRepository.delete(id);
  }
}
