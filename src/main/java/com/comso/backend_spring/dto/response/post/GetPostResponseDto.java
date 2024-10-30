package com.comso.backend_spring.dto.response.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.repository.resultSet.GetPostResultSet;

import lombok.Getter;

@Getter
public class GetPostResponseDto extends ResponseDto{
    
    private int postNumber;
    private String title;
    private String content;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetPostResponseDto(GetPostResultSet resultSet){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        this.postNumber = resultSet.getPostNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
    }

    public static ResponseEntity<GetPostResponseDto> success(GetPostResultSet resultSet){
        GetPostResponseDto result = new GetPostResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    

}
