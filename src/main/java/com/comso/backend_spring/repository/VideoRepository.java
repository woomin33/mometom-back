package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.VideoEntity;

import jakarta.transaction.Transactional;

@Repository
public interface VideoRepository extends JpaRepository<VideoEntity, Integer>{
 
    List<VideoEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
