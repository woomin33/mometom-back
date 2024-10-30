package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.BoardCategoryEntity;
import com.comso.backend_spring.entity.primaryKey.BoardCategoryPk;

import jakarta.transaction.Transactional;

@Repository
public interface BoardCategoryRepository extends JpaRepository<BoardCategoryEntity, BoardCategoryPk>{
    
    List<BoardCategoryEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}
