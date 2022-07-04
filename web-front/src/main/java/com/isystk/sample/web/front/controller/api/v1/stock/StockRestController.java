package com.isystk.sample.web.front.controller.api.v1.stock;

import static com.isystk.sample.common.Const.*;

import com.google.common.collect.Maps;
import com.isystk.sample.common.dto.Page;
import java.math.BigInteger;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.isystk.sample.common.FrontUrl.API_V1_STOCKS;

import com.isystk.sample.common.util.ObjectMapperUtils;
import com.isystk.sample.solr.dto.SolrStockCriteria;
import com.isystk.sample.web.base.controller.api.AbstractRestController;
import com.isystk.sample.web.base.controller.api.resource.PageableResource;
import com.isystk.sample.web.base.controller.api.resource.PageableResourceImpl;
import com.isystk.sample.web.base.controller.api.resource.Resource;
import com.isystk.sample.web.front.dto.StockSearchResultDto;
import com.isystk.sample.web.front.service.StockService;

import lombok.val;

@RestController
@RequestMapping(path = API_V1_STOCKS, produces = MediaType.APPLICATION_JSON_VALUE)
public class StockRestController extends AbstractRestController {

  @Autowired
  StockService stockService;

  @Override
  public String getFunctionName() {
    return "API_POSTS";
  }

  /**
   * 商品一覧を複数取得します。
   *
   * @param form
   * @param page
   * @return
   */
  @GetMapping
  public PageableResource index(StockRestForm form,
      @RequestParam(required = false, defaultValue = "1") int page) {

    // 入力値からDTOを作成する
    val criteria = ObjectMapperUtils.map(form, SolrStockCriteria.class);

    // 10件で区切って取得する
    Page<StockSearchResultDto> stocks = stockService.findSolrAll(criteria, form);

    Map data = Maps.newHashMap();
    data.put("data", stocks.getData());
    data.put("currentPage", form.getPage());
    data.put("total", stocks.getCount());
    PageableResource resource = ObjectMapperUtils.map(data, PageableResourceImpl.class);
    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

  /**
   * 商品詳細を取得します。
   *
   * @param stockId
   * @return
   */
  @GetMapping(value = "/{stockId}")
  public Resource show(@PathVariable BigInteger stockId) {

    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(stockService.findSolrById(stockId).orElse(new StockSearchResultDto())));
    resource.setMessage(getMessage(MESSAGE_SUCCESS));

    return resource;
  }

}
