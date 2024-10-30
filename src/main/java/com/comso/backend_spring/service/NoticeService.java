package com.comso.backend_spring.service;

import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.dto.request.notice.PostNoticeRequestDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeResponseDto;
import com.comso.backend_spring.dto.response.notice.GetNoticeListResponseDto;
import com.comso.backend_spring.dto.response.notice.GetTop5NoticeListResponseDto;
import com.comso.backend_spring.dto.response.notice.PostNoticeResponseDto;

public interface NoticeService {
    ResponseEntity<? super GetNoticeResponseDto> getNotice(Integer noticeNumber);
    ResponseEntity<? super GetNoticeListResponseDto> getNoticeList(Integer devCategoryNumber);
    ResponseEntity<? super GetNoticeListResponseDto> getDevNoticeList(Integer noticeNumber, String devCategoryName);
    ResponseEntity<? super PostNoticeResponseDto> postNotice(Integer corporationNumber, PostNoticeRequestDto dto, String email);
    ResponseEntity<? super GetTop5NoticeListResponseDto> getTop5NoticeList();

}
