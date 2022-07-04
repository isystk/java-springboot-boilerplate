package com.isystk.sample.solr.repository;

import com.isystk.sample.common.dto.Page;
import com.isystk.sample.common.dto.Pageable;
import com.isystk.sample.solr.dto.SolrStock;
import java.math.BigInteger;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface SolrStockRepository extends SolrCrudRepository<SolrStock, String> {

  @Query("stock_id:?0")
  public SolrStock findByStockId(BigInteger stockId);

//    @Query("id:** ?0**  OR title:** ?0** ")
//    public Page<SolrStock> findByCustomQuery(String searchTerm, Pageable pageable);
//
//    @Query(name = "Post.findByNamedQuery")
//    public Page<SolrStock> findByNamedQuery(String searchTerm, Pageable pageable);

}
