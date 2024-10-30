package com.comso.backend_spring.dto.response.notice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.NoticeListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.NoticeListViewEntity;

import lombok.Getter;

@Getter
public class GetNoticeListResponseDto extends ResponseDto {
    
    private List<NoticeListItem> noticeListItems;

    private GetNoticeListResponseDto(List<NoticeListViewEntity> noticeListViewtEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.noticeListItems = NoticeListItem.getList(noticeListViewtEntities);
    }

    public static ResponseEntity<GetNoticeListResponseDto> success(List<NoticeListViewEntity> noticeListViewtEntities){
        GetNoticeListResponseDto result = new GetNoticeListResponseDto(noticeListViewtEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
