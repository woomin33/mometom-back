package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comso.backend_spring.entity.DevCategoryEntity;

public interface DevCategoryRepository extends JpaRepository<DevCategoryEntity, Integer>{
    List<DevCategoryEntity> findByOrderByCategoryNumberAsc();

    

    
}
