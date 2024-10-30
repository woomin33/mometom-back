package com.comso.backend_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comso.backend_spring.dto.request.notice.PostNoticeRequestDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeResponseDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeListResponseDto;
import com.comso.backend_spring.dto.response.notice.GetTop5NoticeListResponseDto;

import com.comso.backend_spring.dto.response.notice.PostNoticeResponseDto;
import com.comso.backend_spring.service.NoticeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/notice")
@RequiredArgsConstructor
public class NoticeController {
    
    private final NoticeService noticeService;

    @GetMapping("/{noticeNumber}")
    public ResponseEntity<? super GetNoticeResponseDto> getNotice(
        @PathVariable("noticeNumber") Integer noticeNumber
    ){
        ResponseEntity<? super GetNoticeResponseDto> response = noticeService.getNotice(noticeNumber);
        return response;
    }

    @GetMapping("/category/{devCategoryNumber}")
    public ResponseEntity<? super GetNoticeListResponseDto> getNoticeList(
        @PathVariable("devCategoryNumber") Integer devCategoryNumber
    ){
        ResponseEntity<? super GetNoticeListResponseDto> response = noticeService.getNoticeList(devCategoryNumber);
        return response;
    }

    @GetMapping("/devNoticeList/{noticeNumber}")
    public ResponseEntity<? super GetNoticeListResponseDto> getDevNoticeList(
        @PathVariable("noticeNumber") Integer noticeNumber,
        @RequestParam("devCategoryName") String devCategoryName
    ){
        ResponseEntity<? super GetNoticeListResponseDto> response = noticeService.getDevNoticeList(noticeNumber, devCategoryName);
        return response;
    }

    @GetMapping("/top-5")
    public ResponseEntity<? super GetTop5NoticeListResponseDto> getTop5NoticeList(){
        ResponseEntity<? super GetTop5NoticeListResponseDto> response = noticeService.getTop5NoticeList();
        return response;
    }

    @PostMapping("{corporationNumber}")
    public ResponseEntity<? super PostNoticeResponseDto> postCorporation(
        @PathVariable("corporationNumber") Integer corporationNumber,
        @RequestBody @Valid PostNoticeRequestDto requestBody,
        @AuthenticationPrincipal String email
    ){
        ResponseEntity<? super PostNoticeResponseDto> response = noticeService.postNotice(corporationNumber, requestBody, email);
        return response;
    }

}
