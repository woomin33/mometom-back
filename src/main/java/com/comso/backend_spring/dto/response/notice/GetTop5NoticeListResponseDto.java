package com.comso.backend_spring.dto.response.notice;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.NoticeListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.NoticeListViewEntity;

import lombok.Getter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetTop5NoticeListResponseDto extends ResponseDto{
    private List<NoticeListItem> top5List;

    private GetTop5NoticeListResponseDto(List<NoticeListViewEntity> noticeListViewEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.top5List = NoticeListItem.getList(noticeListViewEntities);
    }

    public static ResponseEntity<GetTop5NoticeListResponseDto> success(List<NoticeListViewEntity> noticeListViewEntities){
        GetTop5NoticeListResponseDto result = new GetTop5NoticeListResponseDto(noticeListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
