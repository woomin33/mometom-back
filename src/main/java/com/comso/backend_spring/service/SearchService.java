package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.response.search.GetPopularListResponseDto;

public interface SearchService {
    
    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
}
