package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comso.backend_spring.dto.request.post.GetSearchPostListRequestDto;
import com.comso.backend_spring.dto.request.post.PostPostRequestDto;
import com.comso.backend_spring.dto.response.post.GetPostResponseDto;
import com.comso.backend_spring.dto.response.post.PostPostResonseDto;
import com.comso.backend_spring.dto.response.post.GetSearchPostListResponseDto;
import com.comso.backend_spring.dto.response.post.GetPostListResponseDto;
import com.comso.backend_spring.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{postNumber}")
    public ResponseEntity<? super GetPostResponseDto> getPost(
        @PathVariable("postNumber") Integer postNumber
    ){
        ResponseEntity<? super GetPostResponseDto> response = postService.getPost(postNumber);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<? super PostPostResonseDto> postBoard(
        @RequestBody @Valid PostPostRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostPostResonseDto> response = postService.postPost(requestBody, email);
        return response;
    }

     @GetMapping("/post-list")
    public ResponseEntity<? super GetPostListResponseDto> getPostList(
    ){
        ResponseEntity<? super GetPostListResponseDto> response = postService.getPostList();
        return response;
    }

    @PostMapping("/search-post-list")
    public ResponseEntity<? super GetSearchPostListResponseDto> getSearchPostList(
        @RequestBody @Valid GetSearchPostListRequestDto requestBody
    ){
        ResponseEntity<? super GetSearchPostListResponseDto> response = postService.getSearchPostList(requestBody);
        return response;
    }
}