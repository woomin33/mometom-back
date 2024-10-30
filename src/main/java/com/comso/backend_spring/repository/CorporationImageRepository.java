package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.CorporationImageEntity;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface CorporationImageRepository extends JpaRepository<CorporationImageEntity, Integer>{
    
    List<CorporationImageEntity> findByCorporationNumber(Integer corporationNumber);

    @Transactional
    void deleteByCorporationNumber(Integer corporationNumber);
}
