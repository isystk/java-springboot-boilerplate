package com.isystk.sample.domain.repository;

import static com.isystk.sample.domain.util.DomaUtils.createSelectOptions;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.Lists;
import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.NoDataFoundException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.common.util.DateUtils;
import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.domain.dao.OrderHistoryDao;
import com.isystk.sample.domain.dao.OrderHistoryDao;
import com.isystk.sample.domain.dao.StockDao;
import com.isystk.sample.domain.dao.UserDao;
import com.isystk.sample.domain.dto.OrderHistoryCriteria;
import com.isystk.sample.domain.dto.OrderHistoryRepositoryDto;
import com.isystk.sample.domain.entity.OrderHistory;
import com.isystk.sample.domain.entity.OrderHistory;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 注文履歴リポジトリ
 */
@Repository
public class OrderRepository extends BaseRepository {

  @Autowired
  OrderHistoryDao orderHistoryDao;

  @Autowired
  StockDao stockDao;

  @Autowired
  UserDao userDao;

  /**
   * 注文履歴を複数取得します。
   *
   * @param criteria
   * @return
   */
  public List<OrderHistoryRepositoryDto> findAll(OrderHistoryCriteria criteria) {
    var options = createSelectOptions(1, Integer.MAX_VALUE);
    return convertDto(orderHistoryDao.findAll(criteria, options, toList()));
  }

  /**
   * 注文履歴を複数取得します。(ページングあり)
   *
   * @param criteria
   * @param pageable
   * @return
   */
  public Page<OrderHistoryRepositoryDto> findPage(OrderHistoryCriteria criteria, Pageable pageable) {
    var options = createSelectOptions(pageable);
    var orderHistoryList =  convertDto(orderHistoryDao.findAll(criteria, options.count(), toList()));
    return pageFactory.create(orderHistoryList, pageable, options.getCount());
  }

  /**
   * RepositoryDto に変換します。
   *
   * @param orderHistoryList 
   * @return
   */
  private List<OrderHistoryRepositoryDto> convertDto(List<OrderHistory> orderHistoryList) {

    // orderHistoryList を元に、orderHistoryDtoList へコピー
    return ObjectMapperUtils
        .mapAll(orderHistoryList, OrderHistoryRepositoryDto.class);

  }

  /**
   * 注文履歴を取得します。
   *
   * @param criteria
   * @return
   */
  public Optional<OrderHistoryRepositoryDto> findOne(OrderHistoryCriteria criteria) {
    var data = orderHistoryDao.findOne(criteria)
        .orElseThrow(() -> new NoDataFoundException(criteria + "のデータが見つかりません。"));
    return Optional.ofNullable(convertDto(Lists.newArrayList(data)).get(0));
  }

  /**
   * 注文履歴を取得します。
   *
   * @return
   */
  public OrderHistoryRepositoryDto findById(final BigInteger id) {
    var data = orderHistoryDao.selectById(id)
        .orElseThrow(() -> new NoDataFoundException("orderHistory_id=" + id + " のデータが見つかりません。"));
    return convertDto(Lists.newArrayList(data)).get(0);
  }

  /**
   * 注文履歴を追加します。
   *
   * @param orderHistoryDto 
   * @return
   */
  public OrderHistory create(final OrderHistoryRepositoryDto orderHistoryDto) {
    val time = DateUtils.getNow();

    // 注文履歴テーブル
    val orderHistory = ObjectMapperUtils.map(orderHistoryDto, OrderHistory.class);
    orderHistory.setCreatedAt(time); // 作成日
    orderHistory.setUpdatedAt(time); // 更新日
    orderHistory.setDeleteFlg((byte)0); // 削除フラグ
    orderHistory.setVersion(0L); // 楽観ロック改定番号
    orderHistoryDao.insert(orderHistory);

    return orderHistory;
  }

  /**
   * 注文履歴を更新します。
   *
   * @param orderHistoryDto
   * @return
   */
  public OrderHistory update(final OrderHistoryRepositoryDto orderHistoryDto) {
    val time = DateUtils.getNow();

    val before = orderHistoryDao.selectById(orderHistoryDto.getId())
        .orElseThrow(
            () -> new NoDataFoundException("orderHistory_id=" + orderHistoryDto.getId() + " のデータが見つかりません。"));

    // 注文履歴テーブル
    val orderHistory = ObjectMapperUtils.mapExcludeNull(orderHistoryDto, before);
    orderHistory.setUpdatedAt(time); // 更新日
    orderHistoryDao.update(orderHistory);

    return orderHistory;
  }

  /**
   * 注文履歴を論理削除します。
   *
   * @return
   */
  public OrderHistory delete(final BigInteger orderHistoryId) {
    val orderHistory = orderHistoryDao.selectById(orderHistoryId)
        .orElseThrow(() -> new NoDataFoundException("orderHistory_id=" + orderHistoryId + " のデータが見つかりません。"));

    val time = DateUtils.getNow();
    orderHistory.setUpdatedAt(time); // 削除日
    orderHistory.setDeleteFlg((byte) 1); // 削除フラグ
    int updated = orderHistoryDao.update(orderHistory);

    if (updated < 1) {
      throw new NoDataFoundException("orderHistory_id=" + orderHistoryId + " は更新できませんでした。");
    }

    return orderHistory;
  }
}
