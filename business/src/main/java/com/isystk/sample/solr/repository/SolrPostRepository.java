package com.isystk.sample.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.isystk.sample.domain.dto.common.Page;
import com.isystk.sample.domain.dto.common.Pageable;
import com.isystk.sample.solr.dto.SolrPost;

public interface SolrPostRepository extends SolrCrudRepository<SolrPost, String> {

    public List<SolrPost> findByTitle(String title);
//
//    @Query("id:** ?0**  OR title:** ?0** ")
//    public Page<SolrPost> findByCustomQuery(String searchTerm, Pageable pageable);
//
//    @Query(name = "Post.findByNamedQuery")
//    public Page<SolrPost> findByNamedQuery(String searchTerm, Pageable pageable);

}
