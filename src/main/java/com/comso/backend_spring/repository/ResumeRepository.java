package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.BoardEntity;
import com.comso.backend_spring.entity.ResumeEntity;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, Integer> {
    
    boolean existsByResumeNumber(Integer resumeNumber);
    
    BoardEntity findByResumeNumber(Integer resumeNumber);

    
}
