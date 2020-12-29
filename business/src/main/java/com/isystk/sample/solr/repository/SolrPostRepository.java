package com.isystk.sample.solr.repository;

import com.isystk.sample.solr.dto.SolrPost;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface SolrPostRepository extends SolrCrudRepository<SolrPost, String> {

  @Query("post_id:?0")
  public SolrPost findByPostId(Integer postId);

//    @Query("id:** ?0**  OR title:** ?0** ")
//    public Page<SolrPost> findByCustomQuery(String searchTerm, Pageable pageable);
//
//    @Query(name = "Post.findByNamedQuery")
//    public Page<SolrPost> findByNamedQuery(String searchTerm, Pageable pageable);

}
