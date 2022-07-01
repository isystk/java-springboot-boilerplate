package com.isystk.sample.web.admin.service;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.service.BaseTransactionalService;
import com.isystk.sample.common.util.StringUtils;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.OrderHistoryCriteria;
import com.isystk.sample.domain.dto.OrderHistoryRepositoryDto;
import com.isystk.sample.domain.dto.StockCriteria;
import com.isystk.sample.domain.dto.UserCriteria;
import com.isystk.sample.domain.repository.OrderRepository;
import com.isystk.sample.web.admin.dto.OrderHistorySearchConditionDto;
import java.math.BigInteger;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryService extends BaseTransactionalService {

  @Autowired
  OrderRepository orderRepository;

  @Autowired
  UserDao userDao;

  @Autowired
  StockDao stockDao;

  /**
   * 商品を複数取得します。
   *
   * @param dto
   * @return
   */
  public List<OrderHistoryRepositoryDto> findAll(OrderHistorySearchConditionDto dto) {
    return orderRepository.findAll(dtoToCriteria(dto));
  }

  /**
   * 商品を複数取得します。(ページングあり)
   *
   * @param dto
   * @param pageable
   * @return
   */
  public Page<OrderHistoryRepositoryDto> findPage(OrderHistorySearchConditionDto dto, Pageable pageable) {
    return orderRepository.findPage(dtoToCriteria(dto), pageable);
  }


  /**
   * 検索条件を詰める
   *
   * @return
   */
  private OrderHistoryCriteria dtoToCriteria(
      OrderHistorySearchConditionDto dto) {
    // 入力値を詰め替える
    OrderHistoryCriteria criteria = new OrderHistoryCriteria();

    // 注文者での絞り込み
    if (!StringUtils.isBlankOrSpace(dto.getUserName())) {
      UserCriteria userCriteria = new UserCriteria();
      userCriteria.setNameLike(dto.getUserName());
      var userList = userDao.findAll(userCriteria);
      // userListからuserIdのListを抽出
      List<BigInteger> userIdList = userList.stream().map(e -> e.getId())
          .collect(Collectors.toList());
      criteria.setUserIdIn(userIdList);
    }

    // 商品名での絞り込み
    if (!StringUtils.isBlankOrSpace(dto.getStockName())) {
      StockCriteria stockCriteria = new StockCriteria();
      stockCriteria.setNameLike(dto.getStockName());
      var stockList = stockDao.findAll(stockCriteria);
      // stockListからstockIdのListを抽出
      List<BigInteger> stockIdList = stockList.stream().map(e -> e.getId())
          .collect(Collectors.toList());
      criteria.setStockIdIn(stockIdList);
    }

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
  public OrderHistoryRepositoryDto findById(BigInteger stockId) {
    return orderRepository.findById(stockId);
  }

}
