package com.comso.backend_spring.dto.response.notice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class PostNoticeResponseDto extends ResponseDto{
    
    private PostNoticeResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }
    public static ResponseEntity<PostNoticeResponseDto> success(){
        PostNoticeResponseDto result = new PostNoticeResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}
