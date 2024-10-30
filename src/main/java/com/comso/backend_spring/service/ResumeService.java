package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.resume.PostResumeRequestDto;
import com.comso.backend_spring.dto.response.resume.PostResumeResponseDto;
import com.comso.backend_spring.dto.response.resume.GetUserResumeListResponseDto;

public interface ResumeService {
    

    ResponseEntity<? super GetUserResumeListResponseDto> getUserResumeList(String email);
    ResponseEntity<? super PostResumeResponseDto> postResume(PostResumeRequestDto dto, String email);
}
