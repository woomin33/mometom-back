package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.post.GetSearchPostListRequestDto;
import com.comso.backend_spring.dto.request.post.PostPostRequestDto;
import com.comso.backend_spring.dto.response.post.GetPostResponseDto;
import com.comso.backend_spring.dto.response.post.GetSearchPostListResponseDto;
import com.comso.backend_spring.dto.response.post.PostPostResonseDto;
import com.comso.backend_spring.dto.response.post.GetPostListResponseDto;


public interface PostService {
    ResponseEntity<? super GetPostResponseDto> getPost(Integer postNumber);
    ResponseEntity<? super PostPostResonseDto> postPost(PostPostRequestDto dto, String email);
    ResponseEntity<? super GetPostListResponseDto> getPostList();
    ResponseEntity<? super GetSearchPostListResponseDto> getSearchPostList(GetSearchPostListRequestDto dto);
    
}
