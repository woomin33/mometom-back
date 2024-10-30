package com.comso.backend_spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.PostListViewEntity;

@Repository
public interface PostListViewRepository extends JpaRepository<PostListViewEntity, Integer> {

    List<PostListViewEntity> findByTitleContainsOrderByWriteDatetimeDesc(String title);

    List<PostListViewEntity> findByTitleContainsAndWriteDatetimeBetweenOrderByWriteDatetimeDesc(String title, String startDate, String endDate);

    List<PostListViewEntity> findByTitleContainsAndWriteDatetimeGreaterThanEqualOrderByWriteDatetimeDesc(String title, String startDate);

    List<PostListViewEntity> findByTitleContainsAndWriteDatetimeLessThanEqualOrderByWriteDatetimeDesc(String title, String endDate);

    List<PostListViewEntity> findByWriteDatetimeBetweenOrderByWriteDatetimeDesc(String startDate, String endDate);

    List<PostListViewEntity> findByWriteDatetimeGreaterThanEqualOrderByWriteDatetimeDesc(String startDate);

    List<PostListViewEntity> findByWriteDatetimeLessThanEqualOrderByWriteDatetimeDesc(String endDate);
    
    List<PostListViewEntity> findAllByOrderByWriteDatetimeDesc();
    
}
