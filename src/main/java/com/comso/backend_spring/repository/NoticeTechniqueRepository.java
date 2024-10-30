package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.NoticeTechniqueEntity;
import com.comso.backend_spring.entity.primaryKey.NoticeTechniquePk;

import jakarta.transaction.Transactional;

@Repository
public interface NoticeTechniqueRepository extends JpaRepository<NoticeTechniqueEntity, NoticeTechniquePk>{
    
    List<NoticeTechniqueEntity> findByNoticeNumber(Integer noticeNumber);

    @Query(
        value = 
        "SELECT t.technique_name " +
        "FROM notice_technique nt " +
        "INNER JOIN technique t ON nt.technique_number = t.technique_number " +
        "WHERE nt.notice_number = ?1",
        nativeQuery = true
    )
    List<String> findTechniqueNamesByNoticeNumber(Integer noticeNumber);

    @Transactional
    void deleteByNoticeNumber(Integer noticeNumber);
}
