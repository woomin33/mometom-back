package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.corporation.PostCorporationRequestDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationResponseDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationListResponseDto;
import com.comso.backend_spring.dto.response.corporation.PostCorporationResponseDto;

public interface CorporatonService {
    ResponseEntity<? super GetCorporationResponseDto> getCorporation(Integer corporationNumber);
    ResponseEntity<? super GetCorporationResponseDto> getUserCorporation(String email);
    ResponseEntity<? super GetCorporationListResponseDto> getCorporationList();
    ResponseEntity<? super PostCorporationResponseDto> postCorporation(PostCorporationRequestDto dto, String email);
}
