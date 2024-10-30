package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comso.backend_spring.dto.request.user.PatchProfileImageRequestDto;
import com.comso.backend_spring.dto.request.user.PatchUserRequestDto;
import com.comso.backend_spring.dto.response.user.GetSignInUserResponseDto;
import com.comso.backend_spring.dto.response.user.GetUserResponseDto;
import com.comso.backend_spring.dto.response.user.PatchProfileImageResponseDto;
import com.comso.backend_spring.dto.response.user.PatchUserResponseDto;
import com.comso.backend_spring.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userservice;
    
    @GetMapping("/{email}")
    public ResponseEntity<? super GetUserResponseDto> getUser(
        @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserResponseDto> response = userservice.getUser(email);
        return response;
    }
    
    @GetMapping("/")
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super GetSignInUserResponseDto> response = userservice.getSignInUser(email);
        return response;
    }
    
    @PatchMapping("/user")
    public ResponseEntity<? super PatchUserResponseDto> patchUser(
        @RequestBody @Valid PatchUserRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PatchUserResponseDto> response = userservice.patchUser(requestBody, email);
        return response;
    }

    @PatchMapping("/profile-image")
    public ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(
        @RequestBody @Valid PatchProfileImageRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PatchProfileImageResponseDto> response = userservice.patchProfileImage(requestBody, email);
        return response;
    }
}
