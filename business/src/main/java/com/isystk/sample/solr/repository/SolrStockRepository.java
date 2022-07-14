package com.isystk.sample.solr.repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.common.exception.SystemException;
import com.isystk.sample.common.service.BaseRepository;
import com.isystk.sample.domain.entity.Stock;
import com.isystk.sample.solr.dto.SolrStock;
import com.isystk.sample.solr.dto.SolrStockCriteria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SolrStockRepository extends BaseRepository {

  @Autowired
  SolrClient stockSolrClient;

  /**
   * インデックスに1レコード追加します。
   *
   * @param stock
   * @throws Exception
   */
  public void addStocks(SolrStock stock) throws Exception {
    stockSolrClient.addBean(stock);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }


  /**
   * インデックスに複数レコード追加します。
   *
   * @param stockList
   * @throws Exception
   */
  public void addStocks(List<SolrStock> stockList) throws Exception {
    stockSolrClient.addBeans(stockList);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }


  /**
   * SolrInputDocumentを使用してインデックスに１レコード追加します。
   *
   * @param stock
   * @throws Exception
   */
  public void addStockBySolrInputDocument(Stock stock) throws Exception {
    SolrInputDocument solrInputDocument = new SolrInputDocument();
    solrInputDocument.addField("id", stock.getId());
    solrInputDocument.addField("stock_id", stock.getId());
    solrInputDocument.addField("name", stock.getName());
    solrInputDocument.addField("detail", stock.getDetail());
    solrInputDocument.addField("price", stock.getPrice());
    solrInputDocument.addField("quantity", stock.getQuantity());
    solrInputDocument.addField("imgpath", stock.getImgpath());
    solrInputDocument.addField("create_at", stock.getCreatedAt());
    stockSolrClient.add(solrInputDocument);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }


  /**
   * SolrInputDocumentを使用してインデックスに複数レコード追加します。
   *
   * @param stock
   * @throws Exception
   */
  public void addStockBySolrInputDocument(List<SolrStock> stock) throws Exception {
    List<SolrInputDocument> solrInputDocuments = new ArrayList<>();
    for (int i = 0; i < stock.size(); i++) {
      SolrInputDocument solrInputDocument = new SolrInputDocument();
      solrInputDocument.addField("id", stock.get(i).getId());
      solrInputDocument.addField("stock_id", stock.get(i).getId());
      solrInputDocument.addField("name", stock.get(i).getName());
      solrInputDocument.addField("detail", stock.get(i).getDetail());
      solrInputDocument.addField("price", stock.get(i).getPrice());
      solrInputDocument.addField("quantity", stock.get(i).getQuantity());
      solrInputDocument.addField("imgpath", stock.get(i).getImgpath());
      solrInputDocument.addField("create_at", stock.get(i).getCreatedAtDate());
      solrInputDocuments.add(solrInputDocument);
    }
    stockSolrClient.add(solrInputDocuments);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }


  /**
   * インデックスを１レコード更新します。
   *
   * @param stock
   * @throws Exception
   */
  public void updateStock(SolrStock stock) throws Exception {
    stockSolrClient.deleteById(String.valueOf(stock.getId()));
    stockSolrClient.addBean(stock);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }

  /**
   * インデックスを複数レコード更新します。
   *
   * @param stockList
   * @throws Exception
   */
  public void updateStock(List<SolrStock> stockList) throws Exception {
    List<String> ids = Collections.emptyList();
    for (int i = 0; i < stockList.size(); i++) {
      ids.add(stockList.get(i).getId().toString());
    }
    // 指定IDのレコードを削除
    stockSolrClient.deleteById(ids);
    // レコードを追加
    stockSolrClient.addBeans(stockList);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }


  /**
   * インデックスを１レコード削除します。
   *
   * @param id
   * @throws Exception
   */
  public void deleteStock(String id) throws Exception {
    stockSolrClient.deleteById(id);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }

  /**
   * インデックスを複数レコード削除します。
   *
   * @param ids
   * @throws Exception
   */
  public void deleteStock(List<String> ids) throws Exception {
    stockSolrClient.deleteById(ids);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }

  /**
   * インデックスを指定したクエリーで削除します。
   *
   * @param queryString
   * @throws Exception
   */
  public void deleteStockByQuery(String queryString) throws Exception {
    stockSolrClient.deleteByQuery(queryString);
    stockSolrClient.optimize();
    stockSolrClient.commit();
  }

  /**
   * インデックスを指定したクエリーで検索した件数を取得します。
   *
   * @param criteria
   * @return
   * @throws Exception
   */
  public long count(SolrStockCriteria criteria) {
    try {
      List<SolrStock> stockList = new ArrayList<>();
      SolrQuery solrQuery = new SolrQuery();

      // TODO Criteria を元にQueryを組み立てる
      String queryString = "*:*";

      solrQuery.setQuery(queryString);
      solrQuery.setStart(0);
      solrQuery.setRows(Integer.MAX_VALUE);
      QueryResponse queryResponse = stockSolrClient.query(solrQuery);
      return queryResponse.getResults().getNumFound();
    } catch (SolrServerException e) {
      throw new SystemException(e);
    } catch (IOException e) {
      throw new SystemException(e);
    }
  }

  /**
   * インデックスを指定したクエリーで検索します。
   *
   * @param criteria
   * @param pageable
   * @return
   * @throws Exception
   */
  public List<SolrStock> query(SolrStockCriteria criteria, Pageable pageable) {
    try {
      List<SolrStock> stockList = new ArrayList<>();
      SolrQuery solrQuery = new SolrQuery();

      // TODO Criteria を元にQueryを組み立てる
      String queryString = "*:*";

      solrQuery.setQuery(queryString);
      int start = (pageable.getPage() - 1) * pageable.getPerpage();
      solrQuery.setStart(start);
      solrQuery.setRows(pageable.getPerpage());
      solrQuery.setHighlight(true);
      solrQuery.addHighlightField("name");
      solrQuery.addHighlightField("detail");
      solrQuery.setHighlightFragsize(200);
      solrQuery.setHighlightSimplePre("<em>");
      solrQuery.setHighlightSimplePost("</em>");
      solrQuery.addSort("score", SolrQuery.ORDER.desc);
      QueryResponse queryResponse = stockSolrClient.query(solrQuery);
      int qtime = queryResponse.getQTime();//查询花费时间
      SolrDocumentList solrDocumentList = queryResponse.getResults();// 获取查询结果集
      // 获取高亮内容 第一个Map的键是文档的ID，第二个Map的键是高亮显示的字段名
      Map<String, Map<String, List<String>>> highlightingMaps = queryResponse.getHighlighting();
      long totals = solrDocumentList.getNumFound();// 查询到的总记录数
      if (!solrDocumentList.isEmpty()) {
        Iterator<SolrDocument> it = solrDocumentList.iterator();
        while (it.hasNext()) {
          SolrDocument solrDocument = it.next();
          String id = solrDocument.getFieldValue("id").toString();
          Map<String, List<String>> highlightFieldMap = highlightingMaps.get(id);
          if (!highlightFieldMap.isEmpty()) {
            List<String> highlightTitle = highlightFieldMap.get("name");
            List<String> highlightContent = highlightFieldMap.get("detail");
            if (highlightTitle != null && !highlightTitle.isEmpty()) {
              String name = highlightTitle.get(0);
              solrDocument.setField("name", name);
            }
            if (highlightContent != null && !highlightContent.isEmpty()) {
              String detail = highlightContent.get(0);
              solrDocument.setField("detail", detail);
            }
          }
          // 调用solrDocument转java bean
          SolrStock stock = doc2bean(solrDocument);
          stockList.add(stock);
        }
      }
      return stockList;
    } catch (SolrServerException e) {
      throw new SystemException(e);
    } catch (IOException e) {
      throw new SystemException(e);
    }
  }


  /**
   * インデックスを指定したクエリーで検索します。
   *
   * @param criteria
   * @param pageable
   * @return
   * @throws Exception
   */
  public Page<SolrStock> queryPage(SolrStockCriteria criteria, Pageable pageable) {
    List<SolrStock> stockList = new ArrayList<>();

    long count = count(criteria);

    if (0 < count) {
      stockList = query(criteria, pageable);
    }

    return pageFactory.create(stockList, pageable, count);
  }

  /**
   * SolrDocumentをSolrStockに変換します。
   *
   * @param solrDocument
   * @return
   */
  private SolrStock doc2bean(SolrDocument solrDocument) {
    DocumentObjectBinder binder = new DocumentObjectBinder();
    SolrStock stock = binder.getBean(SolrStock.class, solrDocument);
    return stock;
  }

  /**
   * SolrDocumentのListをSolrStockのListに変換します。
   *
   * @param solrDocumentList
   * @return
   */
  private List<SolrStock> doc2beans(SolrDocumentList solrDocumentList) {
    DocumentObjectBinder binder = new DocumentObjectBinder();
    List<SolrStock> stockList = binder.getBeans(SolrStock.class, solrDocumentList);
    return stockList;
  }

  /**
   * SolrStockをSolrInputDocumentに変換します。
   *
   * @param stock
   * @return
   */
  private SolrInputDocument bean2doc(SolrStock stock) {
    DocumentObjectBinder binder = new DocumentObjectBinder();
    SolrInputDocument solrInputDocument = binder.toSolrInputDocument(stock);
    return solrInputDocument;
  }

}
