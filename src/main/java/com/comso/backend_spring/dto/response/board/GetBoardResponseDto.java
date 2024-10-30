package com.comso.backend_spring.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.comso.backend_spring.common.ResponseCode;
import com.comso.backend_spring.common.ResponseMessage;
import com.comso.backend_spring.dto.response.ResponseDto;
import com.comso.backend_spring.entity.ImageEntity;
import com.comso.backend_spring.entity.VideoEntity;
import com.comso.backend_spring.repository.resultSet.GetBoardResultSet;

import lombok.Getter;

@Getter
public class GetBoardResponseDto extends ResponseDto{
    
    private int boardNumber;
    private String title;
    private String content;
    private List<String> boardImageList;
    private List<String> boardVideoList;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetBoardResponseDto(GetBoardResultSet resultSet, List<ImageEntity> imageEntities, List<VideoEntity> videoEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> boardImageList = new ArrayList<>();
        for(ImageEntity imageEntity: imageEntities){
            String boardImage = imageEntity.getImage();
            boardImageList.add(boardImage);
        }
        List<String> boardVideoList = new ArrayList<>();
        for(VideoEntity videoEntity: videoEntities){
            String boardVideo = videoEntity.getVideo();
            boardVideoList.add(boardVideo);
        }
        
        this.boardNumber = resultSet.getBoardNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.boardImageList = boardImageList;
        this.boardVideoList = boardVideoList;
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
    }

    public static ResponseEntity<GetBoardResponseDto> success(GetBoardResultSet resultSet, List<ImageEntity> imageEntities, List<VideoEntity> videoEntities){
        GetBoardResponseDto result = new GetBoardResponseDto(resultSet, imageEntities, videoEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> noExistBoard(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_BOARD, ResponseMessage.NOT_EXISTED_BOARD);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
    

}
