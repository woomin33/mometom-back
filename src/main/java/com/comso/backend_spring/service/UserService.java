package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.response.user.PatchUserResponseDto;
import com.comso.backend_spring.dto.response.user.PatchProfileImageResponseDto;
import com.comso.backend_spring.dto.response.user.GetUserResponseDto;
import com.comso.backend_spring.dto.request.user.PatchProfileImageRequestDto;
import com.comso.backend_spring.dto.request.user.PatchUserRequestDto;
import com.comso.backend_spring.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchUserResponseDto> patchUser(PatchUserRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);
    
}
