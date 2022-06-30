package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.domain.dto.OrderHistoryCriteria;
import com.isystk.sample.domain.dto.OrderHistoryRepositoryDto;
import com.isystk.sample.domain.repository.OrderRepository;
import java.math.BigInteger;
import java.util.List;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryService extends BaseTransactionalService {

  @Autowired
  OrderRepository orderRepository;

  /**
   * 商品を複数取得します。
   *
   * @param criteria
   * @return
   */
  public List<OrderHistoryRepositoryDto> findAll(OrderHistoryCriteria criteria) {
    return orderRepository.findAll(criteria);
  }

  /**
   * 商品を複数取得します。(ページングあり)
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<OrderHistoryRepositoryDto> findPage(OrderHistoryCriteria criteria, Pageable pageable) {
    return orderRepository.findPage(criteria, pageable);
  }


  /**
   * 商品を取得します。
   *
   * @param stockId
   * @return
   */
  public OrderHistoryRepositoryDto findById(BigInteger stockId) {
    return orderRepository.findById(stockId);
  }

}
