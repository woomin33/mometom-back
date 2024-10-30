package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.comso.backend_spring.repository.resultSet.GetPopularListResultSet;

import com.comso.backend_spring.entity.SearchLogPostEntity;

@Repository
public interface SearchLogPostRepository extends JpaRepository<SearchLogPostEntity, Integer>{
    
    @Query(
        value = 
        "SELECT search_word as searchWord, count(search_word) AS count " +
        "FROM search_log_post " +
        "GROUP BY search_word " +
        "ORDER BY count DESC " +
        "LIMIT 10 ",
        nativeQuery = true
    )
    List<GetPopularListResultSet> getPopularList();
}
