package com.comso.backend_spring.dto.response.resume;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.object.ResumeListItem;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.ResumeListViewEntity;

import lombok.Getter;

@Getter
public class GetUserResumeListResponseDto extends ResponseDto {
    private List<ResumeListItem> userResumeList;

    private GetUserResumeListResponseDto(List<ResumeListViewEntity> resumeListViewEntities) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.userResumeList = ResumeListItem.getList(resumeListViewEntities);
    }

    public static ResponseEntity<GetUserResumeListResponseDto> success(List<ResumeListViewEntity> resumeListViewEntities){
        GetUserResumeListResponseDto result = new GetUserResumeListResponseDto(resumeListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
