package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.ResumeTechniqueEntity;
import com.comso.backend_spring.entity.primaryKey.ResumeTechniquePk;

import jakarta.transaction.Transactional;

@Repository
public interface ResumeTechniqueRepository extends JpaRepository<ResumeTechniqueEntity, ResumeTechniquePk>{
    
    List<ResumeTechniqueEntity> findByResumeNumber(Integer resumeNumber);

    @Query(
        value = 
        "SELECT t.technique_name " +
        "FROM resume_technique rt " +
        "INNER JOIN technique t ON rt.technique_number = t.technique_number " +
        "WHERE rt.resume_number = ?1",
        nativeQuery = true
    )
    List<String> findTechniqueNamesByResumeNumber(Integer resumeNumber);

    @Transactional
    void deleteByResumeNumber(Integer resumeNumber);
}




