package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.response.category.GetCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetSelectedCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetDevCategoryListResponseDto;
import com.comso.backend_spring.dto.response.category.GetTechniqueListResponseDto;


public interface CategoryService {
    ResponseEntity<? super GetCategoryListResponseDto> getCategory();
    ResponseEntity<? super GetSelectedCategoryListResponseDto> getSelectedCategory(Integer boardNumber);
    ResponseEntity<? super GetDevCategoryListResponseDto> getDevCategory();
    ResponseEntity<? super GetTechniqueListResponseDto> getTechnique();
}
