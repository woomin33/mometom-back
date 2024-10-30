package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.comso.backend_spring.dto.request.resume.PostResumeRequestDto;
import com.comso.backend_spring.dto.response.resume.PostResumeResponseDto;
import com.comso.backend_spring.dto.response.resume.GetUserResumeListResponseDto;

import com.comso.backend_spring.service.ResumeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/resume")
@RequiredArgsConstructor
public class ResumeController {
    
    private final ResumeService resumeService;

    @GetMapping("/user-resume-list/{email}")
    public ResponseEntity<? super GetUserResumeListResponseDto> getUserBoardList(
        @PathVariable("email") String email
    ){
        ResponseEntity<? super GetUserResumeListResponseDto> response = resumeService.getUserResumeList(email);
        
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostResumeResponseDto> postBoard(
        @RequestBody @Valid PostResumeRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostResumeResponseDto> response = resumeService.postResume(requestBody, email);
        return response;
    }


}

