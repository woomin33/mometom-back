package com.comso.backend_spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.ResumeListViewEntity;

@Repository
public interface ResumeListViewRepository extends JpaRepository<ResumeListViewEntity, Integer> {

    List<ResumeListViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String email);    
}
