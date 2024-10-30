package com.comso.backend_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comso.backend_spring.entity.LocationListViewEntity;


@Repository
public interface LocationListViewRepository extends JpaRepository<LocationListViewEntity, Integer>{
    
}
