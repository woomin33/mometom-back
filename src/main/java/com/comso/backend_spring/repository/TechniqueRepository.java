package com.comso.backend_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comso.backend_spring.entity.TechniqueEntity;

public interface TechniqueRepository extends JpaRepository<TechniqueEntity, Integer>{
    List<TechniqueEntity> findByOrderByTechniqueNumberAsc();
}
