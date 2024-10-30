package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comso.backend_spring.dto.request.corporation.PostCorporationRequestDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationResponseDto;
import com.comso.backend_spring.dto.response.corporation.GetCorporationListResponseDto;
import com.comso.backend_spring.dto.response.corporation.PostCorporationResponseDto;
import com.comso.backend_spring.service.CorporatonService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/corporation")
@RequiredArgsConstructor
public class CorporationController {
    
    private final CorporatonService corporationService;

     @GetMapping("/{corporationNumber}")
    public ResponseEntity<? super GetCorporationResponseDto> getLocation(
        @PathVariable("corporationNumber") Integer corporationNumber
    ){
        ResponseEntity<? super GetCorporationResponseDto> response = corporationService.getCorporation(corporationNumber);
        return response;
    }

    @GetMapping("/user-corporation/{email}")
    public ResponseEntity<? super GetCorporationResponseDto> getUserCorporation(
        @PathVariable("email") String email
    ){
        ResponseEntity<? super GetCorporationResponseDto> response = corporationService.getUserCorporation(email);
        return response;
    }

    @GetMapping("/corporation-list")
    public ResponseEntity<? super GetCorporationListResponseDto> getCorporationList(){
        ResponseEntity<? super GetCorporationListResponseDto> response = corporationService.getCorporationList();
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostCorporationResponseDto> postCorporation(
        @RequestBody @Valid PostCorporationRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostCorporationResponseDto> response = corporationService.postCorporation(requestBody, email);
        return response;
    }

}
