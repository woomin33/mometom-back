package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.auth.SignInRequestDto;
import com.comso.backend_spring.dto.response.auth.SignInResponseDto;
import com.comso.backend_spring.dto.request.auth.SignUpRequestDto;
import com.comso.backend_spring.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
